function traerInformacion(formulario){
    $.ajax({

        url:"https://g27f1bc002fee50-proyectomisiontic.adb.us-phoenix-1.oraclecloudapps.com/ords/admin/client/client",
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
    myTable += "<tr><th>Codigo</th><th>Nombre</th> <th> Correo</th><th>Edad</th></tr>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].email+"</td>";
        myTable+="<td>"+items[i].age+"</td>";
        myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable +="</table>";
    $("#resultado").append(myTable);
}

function guardarInformacion(){

    $("#resultado").empty();

    let myData ={id:$("#id").val(),name:$("#name").val(),email:$("#email").val(),age:$("#age").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : 'https://g27f1bc002fee50-proyectomisiontic.adb.us-phoenix-1.oraclecloudapps.com/ords/admin/client/client',
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

    let myData ={id:$("#id").val(), name:$("#name").val(),email:$("#email").val(),age:$("#age").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : 'https://g27f1bc002fee50-proyectomisiontic.adb.us-phoenix-1.oraclecloudapps.com/ords/admin/client/client',
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

            url          : 'https://g27f1bc002fee50-proyectomisiontic.adb.us-phoenix-1.oraclecloudapps.com/ords/admin/client/client',
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

            url          : 'https://g27f1bc002fee50-proyectomisiontic.adb.us-phoenix-1.oraclecloudapps.com/ords/admin/client/client' + codigo ,
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