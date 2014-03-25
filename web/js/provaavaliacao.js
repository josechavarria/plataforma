function changeIndex(val){
    
     $.ajax({
                     
                    type: "POST",
                     data:{"mode":val},  
                    url: "setIndexProva",
                    dataType: "html",
                    beforeSend: function(){
                        $('#messages').html('<div style=" float:right" class="alert alert-info"> A pedir </div>');
                       // 
                     },
                    success: function(result){
                       
                        location.href="responderTeste.jsp";
                    },error:function(){
                        
                        
                        
                    }
                 });
    
    
}
function inserirResposta(id){ // por uma determinada div
  
   
   
     $.ajax({     
  type: 'POST',
  data: {'resposta':id},
  url: 'inserirRespostasTeste',
  beforeSend: function(){
                        $('#messages').html('<div style=" float:right" class="alert alert-info"> A pedir </div>');
                       // 
                     },
  success:function(result){
         $('#messages').html('<div style=" float:right" class="alert alert-info"> Inserida </div>');
                   
  }
  
    });
} ; 
function terminarTeste(){
                $.ajax({
                     
                    type: "POST",
                        url: "terminarProvaAvaliacao",
                   
                    beforeSend: function(){
                        $('#messages').html('<div style=" float:right" class="alert alert-info"> A pedir </div>');
                       // 
                     },
                    success: function(result){
                                window.open('relatorioProva','_newtab');
                                      
              
                          location.href="responderTeste.jsp";
                          },error:function(){
                        alert('Não foi possivel registar o testes');
                        
                        
                    }
                 });
    
    
}
$(document).ready(function(){
    
    $("#bPanterior").click(function(){
            changeIndex(false);
            
            });
             $("#bPseguinte").click(function(){
            changeIndex(true);
            
            });
            $("#bFinalizarProva").click(function(){
            terminarTeste();
            
            });
            $('#respostaT0').click(function(){inserirResposta(0);   
            });$('#respostaT1').click(function(){inserirResposta(1)    
            ;});$('#respostaT2').click(function(){inserirResposta(2)    
            ;});$('#respostaT3').click(function(){inserirResposta(3)    
            ;});
    
    
    
});


