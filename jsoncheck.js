/**
* JSONファイルをチェックする (node.js)
* 使い方
* - このファイルを任意の場所に置く
*   例: ~/jsoncheck.js
* - jsonファイルのパスをpipeで渡して実行する
*   例: $ find . -name "*.json"|node ~/jsoncheck.js
* - エラーがあればコンソールに表示され、exit(1)を返す。
*/
/* jslint node: true */

var fs = require('fs');

//------------
// ライブラリ
//------------
// Promiseっぽいもの
var MyPromise = function(context, parent) {
  var _parent = parent;
  var nextPromise;
  var _resolve, _reject;
  var emptyAction = function(){};
  
  return {
    then: function(resolve, reject) {
      _resolve = resolve || emptyAction;
      _reject = reject || emptyAction;
      nextPromise = MyPromise(context, this);
      return nextPromise;
    },
    run: function() {
      if(_parent) {
        _parent.run();
      } else {
        this.onResolve(context);
      }
    },
    onResolve: function(p) {
      var result = _resolve(
        p, 
        function(p) {
          nextPromise.onResolve(p);
        },
        function(e) {
          nextPromise.onReject(e);
        }
      );
    },
    onReject: function(e) {
      _reject(e);
    }
  };
};

// パイプで各行を受け取る
var eachLinesByPipe = function(onFindLine, onEnd) {
  if(process.stdin.isTTY) return;// パイプじゃない場合
  process.stdin.resume();
  process.stdin.setEncoding('utf8');
  var fragment = "";
  process.stdin.on('data', function(chunk){
    if (chunk === "") { return ;}
    var lines = chunk.split("\n");
    lines[0] = fragment + lines[0];
    fragment = lines.pop();
    lines.forEach(onFindLine);
  });
  process.stdin.on('end', onEnd);
};

//-----------------
// 本ちゃんの処理群
//-----------------

var fileNameFilter = function(extension) {
  return function(filename, resolve, reject) {
    if(filename.indexOf(extension) + extension.length == filename.length) {
      resolve(filename);
    } else {
      reject("not json file");
    }
  };
};

var getFileText = function(filename, resolve, reject) {
  var result = fs.readFileSync(filename, 'utf8');
  if(result) resolve(result); else reject("file access error");
};

var parseJSON = function(strjson, resolve, reject) {
  try {
    resolve(JSON.parse(strjson));
  } catch(e) {
    reject(e);
  }
};

//-------------------
// エントリーポイント
//-------------------
var result = {
  jsonFileCount: 0,
  errors: []
};
eachLinesByPipe(
  // ファイルごとにjsonを確認する
  function checkJSONFile(filename) {
    MyPromise(filename)
      .then(fileNameFilter('.json'))
      .then(getFileText)
      .then(parseJSON)
      .then(function(){}, function error(e) {
          result.errors.push({
          filename: filename,
          error: e
        });
      })
      .run();
  }, 
  // プリントアウト
  function printResult() {
    if(result.errors.length === 0) {
      console.log('ALL SUCCESS.');
      return;
    }
    console.log('ERROR: ' + result.errors.length);
    result.errors.forEach(function(e) {
      console.log('------');
      console.log(e.filename);
      console.log(e.error);
    });
    process.exit(1); // エラーがあるので異常終了
  }
);
