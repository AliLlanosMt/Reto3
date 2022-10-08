const Base_url = 'Http://144.24.30.85'
function traerInformacion(){
    $.ajax({

        url: Base_url + "/api/Car/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            pintarRespuesta(respuesta.items);

        }





    });



}
function pintarRespuesta(items){

    $("#resultado").empty();

    //declarar variables js
    let myTable="<table>";
    myTable += "<tr><th>Codigo</th><th>marca</th> <th> modelo</th><th>codigo de categoria</th></tr>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].brand+"</td>";
        myTable+="<td>"+items[i].model+"</td>";
        myTable+="<td>"+items[i].category_id+"</td>";
        myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable +="</table>";
    $("#resultado").append(myTable);
}

function guardarInformacion(){

    $("#resultado").empty();

    let myData ={id:$("#id").val(),brand:$("#brand").val(),model:$("#model").val(),category_id:$("#category_id").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : Base_url + "/api/Car/save",
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                //console.log(respuesta);
                alert("Inserción exitosa");
            },
            error       :   function(xhr,status){
                alert('Operacion no satisfactoria,'+ xhr.status );
            }

        }
    );
}


function editarInformacion() {

    let myData ={id:$("#id").val(),brand:$("#brand").val(),model:$("#model").val(),category_id:$("#category_id").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : Base_url + "/api/Car/save",
            type         : 'PUT',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                //console.log(respuesta);
                alert("Actualizacion exitosa");
            },
            error       :   function(xhr,status){
                alert('Operacion no satisfactoria,'+ xhr.status );
            }

        }
    );

}

function borrarElemento(idElemento){


    let myData ={id:idElemento}
    let dataToSend   = JSON.stringify(myData);

    $.ajax (
        {

            url          : Base_url + "/api/Car/delete",
            type         : 'DELETE',
            data         :  dataToSend,
            contentType  : 'application/json',
            datatype     :  "JSON",
            success      :  function(respuesta){
                // console.log(respuesta);
                alert("Borrado exitoso");
            },
            error       :   function(xhr,status){
                alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );


}


function consultarId() {

    let codigo = $("#id").val();

    $.ajax (
        {

            url          : Base_url + "/api/Car/{id}" ,
            type         : 'GET',
            dataType     : 'json',
            success      :  function(respuesta){
                pintarRespuesta(respuesta.items);
            },
            error       :   function(xhr,status){
                alert('Operacion no satisfactoria,'+ xhr.status );
            },



        }
    );
}