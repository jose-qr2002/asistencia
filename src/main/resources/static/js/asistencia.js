
$(document).ready(function () {
   listarAsistencias();
});

function listarAsistencias() {
    $.ajax({
        url: "/asistencia/listar",
        type: 'GET',
        success: function(x) {
            $("#tablaAsistencia tbody tr").remove();
            x.forEach((item, index) => {
                $("#tablaAsistencia").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.persona.persNombre +" "+ item.persona.persApellido + "</td>\n\
                            <td>" + item.asisFecha + "</td>\n\
                            <td>" + item.asisHora + "</td>\n\
                            <td>" + item.asisTipoControl + "</td>\n\
                        </tr>");
            });
        }
    });
}

function enviarAsistencia(horaActual){
    $.ajax({
        url: "/asistencia/guardar",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            persona: {
                persId: $("#idAsistencia").val()
            },
            asisHora: horaActual,
            asisTipoControl: $("#tipoControl").val()
        }),
        cache: false,
        success: function (data) {
            var dialog = bootbox.dialog({
                message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro Guardado Correctamente.</p>',
                closeButton: false
            });
            setTimeout(function () {
                dialog.modal('hide');
            }, 1500);
            listarAsistencias();
        },
        error: function() {
            mostrarErrorEnvio();
        }
    });
}

$("#guardarAsistencia").click(function (e) {
    var dniBuscado = $("#buscarDni").val();
    //validaciones
    if (dniBuscado.length != 8){
        mostrarErrorDni();
    } else if(!$("#tipoControl").val()) {
        mostrarErrorControl();
    }else {
        buscarPersona(dniBuscado);
        var horaFinal = generarHoraActual();
        setTimeout(function () {
            enviarAsistencia(horaFinal);  //ENVIA A LA BASE DE DATOS
            limpiarAsistencia();
            $("errorDni").addClass("d-none");
            $("errorControl").addClass("d-none");
            $("#errorEnvio").addClass("d-none");
        }, 300);
    }
    
    
    
    
    
});

function buscarPersona(dni){
    $.ajax({
        url: "/persona/dni/" + dni,
        type: 'GET',
        success: function(data) {
            $("#idAsistencia").val(data.persId);
        }
    });
}

function limpiarAsistencia() {
    $("#tipoControl").val('Tipo de Control');
    $("#idAsistencia").val('');
    $("#buscarDni").val('');
}

function generarHoraActual(){
    var horaActual = new Date();
    var horaFormateada = horaActual.toLocaleTimeString();
    return horaFormateada;
    //var fechaActual = `${actual.getDate()}/${actual.getMonth()}/${actual.getFullYear()}`;
    //var horas = actual.getHours();
    //var minutos = actual.getMinutes();
    //var segundos = actual.getSeconds();
    //if (horas.length=)
    //var horaActual = `${)}:${}:${actual.getSeconds()}`;
}

function mostrarErrorDni(){
    $("#errorDni").removeClass("d-none");
    setTimeout(function () {
        $("#errorDni").addClass("d-none")
    }, 3000);
}

function mostrarErrorControl(){
    $("#errorControl").removeClass("d-none");
    setTimeout(function () {
        $("#errorControl").addClass("d-none")
    }, 3000);
}

function mostrarErrorEnvio(){
    $("#errorEnvio").removeClass("d-none");
    setTimeout(function () {
        $("#errorEnvio").addClass("d-none");
    }, 3000);
}