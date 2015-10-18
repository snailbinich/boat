// define([], function() {

//   return {
//     hello: function() {
//       alert("hello, app~");
//     }
//   }
// });

define([], function(){

      var hello = function(){
      	alert("hello");
      }
      return {
      	hello:hello
      };
});


