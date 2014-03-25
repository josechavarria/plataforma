
       function fixedEncodeURIComponent (str) {
  return encodeURIComponent(str).replace(/[!'()]/g, escape).replace(/\*/g, "%2A");
}//found in http://stackoverflow.com/questions/6544564/url-encode-a-string-in-jquery-for-an-ajax-request
     
           function insertChar(char,id){
        $("#textArea"+id).val($("#textArea"+id).val()+char);
        
        
         }
         
         
         
         
         
 function checkboxuc(){   //carregar valor de todas as checkbox 
                var ucs = $('input:checkbox:checked.ucscheck').map(function () {
                 return   this.value;
                }).get();    
                return ucs;
            };
      function checkboxcurso (){   //carregar valor de todas as checkbox 
                var ucs = $('input:checkbox:checked.cursoscheck').map(function () {
                 return   this.value;
                }).get();    
                return ucs;
            }; 
      function strreplace(str){
            
            str = str.replace(/ /g, '\\:');
           str=str.replace(/(\r\n|\n|\r)/gm,"\\\\");
           // str = str.replace(/\& /g, 'qwwqeqweqwe');
          return str;
      }
         
     
     function refreshIt(id)  {
                                        strin = $('#textArea'+id).val();
                                      // strin=strreplace(strin);
                                       $('#textArea'+id).val(strin);
                                         an=$('#textArea'+id).val();
                                        $.base64.utf8encode = true;
                                         $("#image"+id).attr('src', 'DispImage?latex='+$.base64.encode(an));
                                        
                                         /* $.ajax({
                                                type: "POST",
                                                url: "DispImage",
                                                data: {'latex':$.base64.encode(an) },
                                               // contentType: "image/png",
 
                                                dataType: "image/png",
                                                success: function() {
                                                   alert('mbjvchxzcfgvhbjnkm');
                                                  // $('#imgarea'+id).html('<img src="'+ img +'" alt="img" />');
                                                },
                                                error: function(error, txtStatus) {
                                                  console.log(txtStatus);
                                                  console.log('error');
                                                  }
                                            });*/
                            };         
       function copyLatex(id){
                                           
                                           
                                          ans = document.DragMath.getMathExpression();
                                          
                                          $('#textArea'+id).val($('#textArea'+id).val()+ans).trigger('change');
                                       };
                         function  showDiv(id){
                                          for(i=0;i<9;i++){
                                              $('#div'+i).hide();
                                          }
                                          $('#div'+id).show();
                                          
                                      };     
            
 
    
    
    
    $(document).ready(function (){
        
                                                       
            
         var couldsend=false;
        $('textarea.latexin').trigger('change');                          
        $('#clearM').click(function(){
             
               $('#messages').html('');
             
             
         }); 
        $('#novaP').click(function(){
       
               $.ajax({
                     
                    type: "GET",
                       
                    url: "newEditQuestion",
                    dataType: "html",
                    beforeSend: function(){
                        $('#messages').html('<div style=" float:right" class="alert alert-info"> A pedir </div>');
                       // 
                     },
                    success: function(result){
                        $('#Inserir').html(result);
                      //  alert('addfsas');
                        //$(document).trigger('ready');
                        $.getScript('js/editor.js', function() {
                        });
                    }
                 });
             
             
         });  
        $('#capitulos').change(function(){
                $.ajax({     
                type: 'GET',
                 url: 'getucscapitulo?capitulo='+$('#capitulos').val(),     
                success:function(result){
                   if(result!==""){
                    $('#divucs').html('<label>Unidade Curricular </label>'+result);
                     $.ajax({     
                        type: 'GET',
                         url: 'getcursoscapitulo?capitulo='+$('#capitulos').val(),     
                        success:function(result){
                            $('#divcursos').html('<label> Cursos </label>'+result);
                            if(result!==""){
                            couldsend=true;
                            }
                        }, error: function(){
                             $('#divucs').html('');
                          $('#divcursos').html('');
                          couldsend=false;
                            
                        }
                        }); 

                    }else{
                         $('#divucs').html('');
                          $('#divcursos').html('');
                          couldsend=false;
                    }
                
                },
                error: function(){
                     $('#divucs').html('');
                          $('#divcursos').html('');
                   
                }
                }); 
               
                
             
             });      
             //enviar pergunta
        $('#submitq').click( function(){
             $.base64.utf8encode = true;
                                       
            if(couldsend){
                    $('#messages').html('');
                    correta=$("[name='correta']:checked").val();
                    unics=checkboxuc().toString();
                    curs=checkboxcurso().toString();
                    pergunta=$.base64.encode($('#textArea0').val());
                    r1=$.base64.encode($('#textArea1').val());
                    r2=$.base64.encode($('#textArea2').val());
                    r3=$.base64.encode($('#textArea3').val());
                    r4=$.base64.encode($('#textArea4').val());
                    r5=$.base64.encode($('#textArea5').val());
                    r6=$.base64.encode($('#textArea6').val());
                    r7=$.base64.encode($('#textArea7').val());
               
                    dica=$('#textArea8').val();
                    capitulo= $('#capitulos').val();
                    if(!$.isNumeric(capitulo)){
                        control=false;
                         $('#messages').append('<div style=" float:right" class="alert alert-error"> Insira o capitulo pretendido</div>');


                    } 
                     control=true;
                     if(unics===''){
                         control=confirm("Deixou as Unidades  em branco \n Pertende que esta pergunta\n esteja associada a todas as unidades curriculares?");  
                         if(control===true){
                             unics='all';
                             }
                         }else{
                             unics=unics+',';
                             
                         }
                     if(curs===''){
                         control=confirm("Deixou Os cursos  em branco \n Pertende que esta pergunta\n esteja associada a todas as unidades curriculares?");  
                         if(control===true){
                             curs='all';

                         }
                         }else{
                             curs=curs+',';
                             
                         }
                     if($.isNumeric(correta)){
                       control=true;  
                     }else{
                         control=false;
                         $('#messages').append('&#09 <div style=" float:right" class=" alert alert-error"> Insira a respota correta  </div>');
                         
                }
                     if(control===true){
                          
                      //continuar com o formulario 
                    dados={'capi':capitulo,'cor':correta,'per':pergunta,'r1':r1,'r2':r2,'r3':r3,'r4':r4,'r5':r5,'r6':r6,'r7':r7,'dica':dica, 'ucs': unics, 'cur':curs};
                      $.ajax({ 
                         type: "GET",
                         data: dados,

                         url: "registarperguntas",
                         dataType: "html",
                         beforeSend: function(){
                             $('#messages').html('<div style=" float:right" class="alert alert-info"> A enviar </div>');

                          },
                         success: function(result){
                             if(result==='Sucesso'){
                                  $('#messages').html('<div style=" float:right" class="alert alert-sucess"> <h3>Pergunta inserida com Sucesso </h3></div>');

                             }else{
                                  $('#messages').html('<div style=" float:right" class="alert alert-error"> <h3>'+result+'</h3> </div>');

                             }

                          }




                     });
                     }
                 }else{
                     alert("o capitulo selecionado não pode ser processado");
                 }    
        });
        $("#ifrI").load(function() {
                                        $(this).height($(this).contents().height());
                                       
                                        });

        $('#btndispdrag').click(function(){

      $('#asideapplet').append('<applet  name="DragMath" codebase="applet" code="Display.MainApplet.class" archive="DragMath.jar" width=540 height=333><param name=language value="en"><param name=outputFormat value="Latex"></applet >');
       $('#btndispdrag').hide();
       $('#copybar').show();
       });
       $('#btnPergunta').click(function(){
          showDiv(0);});

           $('#btn1').click(function(){
          showDiv(1);});
       $('#btn2').click(function(){
          showDiv(2);});
       $('#btn3').click(function(){
          showDiv(3);});
       $('#btn4').click(function(){
          showDiv(4);});
       $('#btn5').click(function(){
          showDiv(5);});
       $('#btn6').click(function(){
          showDiv(6);});
       $('#btn7').click(function(){
          showDiv(7);});
        $('#btnDica').click(function(){
          showDiv(8);});

     $('#textArea0').change(function(){refreshIt(0);});
       $('#textArea1').change(function(){refreshIt(1);});
      $('#textArea2').change(function(){refreshIt(2);});
       $('#textArea3').change(function(){refreshIt(3);});
      $('#textArea4').change(function(){refreshIt(4);});
       $('#textArea5').change(function(){refreshIt(5);});
      $('#textArea6').change(function(){refreshIt(6);});
       $('#textArea7').change(function(){refreshIt(7);});
        $('#dispDrag').click(function(){

        });
      $('#copy0').click(function(){copyLatex(0);});
      $('#copy1').click(function(){copyLatex(1);});
      $('#copy2').click(function(){copyLatex(2);});
      $('#copy3').click(function(){copyLatex(3);});
      $('#copy4').click(function(){copyLatex(4);});
      $('#copy5').click(function(){copyLatex(5);});
      $('#copy6').click(function(){copyLatex(6);});
      $('#copy7').click(function(){copyLatex(7);});
      $('#copy8').click(function(){copyLatex(8);});
      
      $('#bespaco0').click(function(){insertChar("\\:",0);});
        $('#benter0').click(function(){insertChar("\\\\",0);});
        $('#bespaco1').click(function(){insertChar("\\:",1);});
        $('#benter1').click(function(){insertChar("\\\\",1);});
        $('#bespaco2').click(function(){insertChar("\\:",2);});
        $('#benter2').click(function(){insertChar("\\\\",2);});
        $('#bespaco3').click(function(){insertChar("\\:",3);});
        $('#benter3').click(function(){insertChar("\\\\",3);});
        $('#bespaco4').click(function(){insertChar("\\:",4);});
        $('#benter4').click(function(){insertChar("\\\\",4);});
        $('#bespaco5').click(function(){insertChar("\\:",5);});
        $('#benter5').click(function(){insertChar("\\\\",5);});
        $('#bespaco6').click(function(){insertChar("\\:",6);});
        $('#benter6').click(function(){insertChar("\\\\",6);});
        $('#bespaco7').click(function(){insertChar("\\:",7);});
        $('#benter7').click(function(){insertChar("\\\\",7);});
        
        }
    
    
    );
  
    
                                   
                                     
                                     


  
       

