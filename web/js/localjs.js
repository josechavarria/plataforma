          function processForm(formId,URL) { 
            
        
       $('[type=password]').val(function (){
               
             return $().crypt({method:"sha1",source:$(this).val()}); 
           
               
               
           });
           
              dados=$("#"+formId).serialize();
                //your validation code
    $.ajax( {
            type: 'POST',
            url: URL,
            data:dados , 
            success: function(result) {
               alert(result);
            },error:function(){
               alert('Não foi possivel processar o seu pedido'); 
                
                
            }
        } );
      
    }
      function processFormInserirTeste(formId,URL) { 
            
        
       $('[type=password]').val(function (){
               
             return $().crypt({method:"sha1",source:$(this).val()}); 
           
               
               
           });
           
            
            
              dados=$("#"+formId).serialize();
                //your validation code
    $.ajax( {
            type: 'POST',
            url: URL,
            data:dados , 
            success: function(result) {
               alert(result);
            },error:function(){
               alert('Não foi possivel processar o seu pedido'); 
                
                
            }
        } );
      
    }
     function processFormTeste(formId,URL) { 
            
        
       $('[type=password]').val(function (){
               
             return $().crypt({method:"sha1",source:$(this).val()}); 
           
               
               
           });
            
    $.ajax( {
            type: 'POST',
            url: URL,
            data:dados , 
            success: function(result) {
               alert(result);
            },error:function(){
               alert('Não foi possivel processar o seu pedido'); 
                
                
            }
        } );
      
    }
   $(document).ready(function(){
          
          $('iframe').height($(this).height());
         $('iframe').width($(this).width());
           $('#myTab a').click(function (e) {
                                        e.preventDefault();
                                        $(this).tab('show');
                                        });
                                        
           $('#logout').click( function (){
               
             document.location.href='logout';
               
             $('[type=number]').change(function(){
                  alert('Insira um número válido');
                    
                 if(!isNumeric($(this).val())){
                     alert('Insira um número válido');
                     $(this).val('');
                 }
                 
                 
                 
             });
               
           });
          
                                       
});
                                       


