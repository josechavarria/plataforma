$(document).ready(function() {
  /*$("#submitT").submit(function() {

    // do the extra stuff here
    dados=
    $.ajax({
     
     type: "POST",
      url: "echo",
      data: $('#novoTeste').serialize(),
      success: function() {
        alert('Sucesso');
       }
    });

  });*/
  
  
  ///
  $('#turnoalvo').change(function(){
      
      $.ajax({
     
     type: "GET",
      url: "capitulosturno?turno="+ $('#turnoalvo').val(),
      success: function(result) {
        $('#capitulosArea').html(result);
       }
    });
      
      
      
  });
});