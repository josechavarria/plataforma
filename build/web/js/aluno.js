   $(document).ready(function(){
       
  $("#terminarTeste").click( function(){
      alert(9);
         $.ajax({     
            type: 'POST',
            url: 'relatoriocaderno',
           
            success:function(data){
                  var win = window.open();
            win.document.write(data);
                
  }
  
    });
 
    }
);
                                     
                                        $('#selectUC').change(function(){
                                              
                                          
                                                 
                                                  $.ajax({     
                                                    type: 'GET',
                                                    url: 'getCapitulosUc?Uc='+$('#selectUC').val(),     
                                                    success:function(result){
                                                        
                                                         $('#selectCapitulo').html(result);
                                                     }
                                                 });  });                                                                                                                        
                                                 $('#selectCapitulo').change(function(){
                                              
                                          
                                                 
                                                  $.ajax({     
                                                    type: 'GET',
                                                    url: 'trocarCapitulo?novo='+$('#selectCapitulo').val(),     
                                                    success:function(result){
                                                         
                                                    }
                                                 });  });   
                                 
                                        
                                      
                                     });