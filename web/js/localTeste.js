/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ $(document).ready(function(){
    //declare function 
var respostaDada=function(id,pergunta){ // por uma determinada div
  
    blockall();
   
     $.ajax({     
  type: 'GET',
  url: 'iscorret'+'?id='+id+'\&pergunta='+pergunta,
  assync :false,
  success:function(result){
     //verify(result,id);
     getAttempsVerify(result,pergunta,id);
  }
  
    });
} ;  
 
var unblockall=function(){ // bloquear todas as checkbox e mostrar botão de seguinte
    $("#cresposta0").attr({"disabled" : false});
    $("#cresposta1").attr({"disabled" : false});
    $("#cresposta2").attr({"disabled" : false});
    $("#cresposta3").attr({"disabled" : false});
  

   };
   var blockall=function(){ // bloquear todas as checkbox e mostrar botão de seguinte
    $("#cresposta0").attr({"disabled" : true});
    $("#cresposta1").attr({"disabled" : true});
    $("#cresposta2").attr({"disabled" : true});
    $("#cresposta3").attr({"disabled" : true});
  

   };
  
   var putGreen=function(id){ // por uma determinada div
   $("#div"+id).css("background-color","#00FF00");
   };
   var putRed=function(id){ // por uma determinada div
   $("#div"+id).css("background-color","#FF0000");
   };  
  
var getAttempsVerify=function(result,pergunta,id){ // por uma determinada div
    var resq;
    
    $.ajax({     
  type: 'GET',
  url: 'getTentativas?pergunta='+pergunta, 

  success:function(attemps){
    
      if(result==="true"){
           putGreen(id);
           blockall();
            $("#bSeguinte").show();
       }else{        
           putRed(id);
            if(attemps>=2){
                blockall();
      
         $("#bSeguinte").show();
        }else{
            unblockall();   
            
         
        }
       }

  }

});     
   };
var newquestion=function(){ // por uma determinada div
    var resq;
    $("#bSeguinte").hide();
    
    $.ajax({     
  type: 'GET',
  url: 'NewrndQ',
   success:function(result){
       $("#bSeguinte").show();
     
document.location.href='pergunta.jsp'; 
  },error:function(result){
       alert(result);
  }
  
});   

   };
var loadnew=function(){ // por uma determinada div
    var resq;
    
    $.ajax({     
  type: 'GET',
  url: 'NewrndQ',

  success:function(result){
      
    alert(result);   

  }

});

   



};   

 });
 
 



