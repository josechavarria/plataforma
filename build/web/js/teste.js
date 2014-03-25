/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    //declare function 
 
  
  
$(document).ready(function(){
    
    function respostaDada (id){ // por uma determinada div
  
    blockall();
   
     $.ajax({     
  type: 'GET',
  url: 'iscorret'+'?id='+id,
  assync :false,
  success:function(result){
     //verify(result,id);
     getAttempsVerify(result,id);
  }
  
    });
} ;  
 
 function unblockall(){ // bloquear todas as checkbox e mostrar botão de seguinte
    $("#cresposta0").attr({"disabled" : false});
    $("#cresposta1").attr({"disabled" : false});
    $("#cresposta2").attr({"disabled" : false});
    $("#cresposta3").attr({"disabled" : false});
  

   };
    function blockall(){ // bloquear todas as checkbox e mostrar botão de seguinte
    $("#cresposta0").attr({"disabled" : true});
    $("#cresposta1").attr({"disabled" : true});
    $("#cresposta2").attr({"disabled" : true});
    $("#cresposta3").attr({"disabled" : true});
  

   };
  
     function putGreen(id){ // por uma determinada div
   $("#div"+id).css("background-color","#00FF00");
   };
   var putRed=function(id){ // por uma determinada div
   $("#div"+id).css("background-color","#FF0000");
   };  
  
 function getAttempsVerify(result,id){ // por uma determinada div
    var resq;
    
    $.ajax({     
  type: 'GET',
  url: 'getTentativas', 

  success:function(attemps){
    
      if(result==="true"){
           putGreen(id);
           blockall();
            $("#bSeguinte").show();
             $("#terminarTeste").show();
 
      }else{        
           putRed(id);
            if(attemps>=2){
                blockall();
              $("#terminarTeste").css("display","innerit");
               
         $("#bSeguinte").show();
        }else{
            unblockall();   
          $("#dica").css("display","innerit");
             
        }
       }

  }

});     
   };
   
    
    
    
    
    $("#bSeguinte").click( function(){
          $("#bSeguinte").hide();
          $("#terminarTeste").css("display","none");
    $.ajax({     
  type: 'GET',
  url: 'NewrndQ',
   success:function(result){
       $("#bSeguinte").show();
  
       if(result==='1'){
        document.location.href='pergunta.jsp'; 
        
        }else{
            
            alert('selecione outro capitulo');
        }
  },error:function(result){
       alert(result);
  }
  
}); 
 
    }
);
    
   $("#cresposta0").click(function(){
          
          respostaDada (0);
          
      });
      $("#cresposta1").click(function(){
          
          respostaDada (1);
          
      });
      $("#cresposta2").click(function(){
          
          respostaDada (2);
          
      });
      $("#cresposta3").click(function(){
          
          respostaDada (3);
          
      });  
     
    
});