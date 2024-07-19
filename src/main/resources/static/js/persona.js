$(document).ready(function () {
   console.log("HOLA A TODOS");
   listar();
});


function listar() {
    $.ajax({
        url: "/persona/listar",
        type: 'GET',
        success: function(x) {
            $("#tabla tbody tr").remove();
            x.forEach((item, index) => {
                $("#tabla").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.persApellido + "</td>\n\
                            <td>" + item.persNombre + "</td>\n\
                            <td>" + item.persDni + "</td>\n\
                            <td>" + item.persSexo + "</td>\n\
                            <td>" + item.persDireccion + "</td>\n\
                            <td class='text-center'>\n\
                                <a href='#' onclick='editar(" + item.persId + ")'><i class='fa-solid fa-pen-to-square text-warning'></i></a>\n\
                            </td>\n\
                            <td class='text-center'>\n\
                                <a href='#' onclick='eliminar(" + item.persId + ")'><i class='fa-solid fa-trash text-danger'></i></a>\n\
                            </td>\n\
                        </tr>");
            });
        }
    });
}

function editar(id) {
    $.ajax({
        url: "/persona/" + id,
        type: 'GET',
        success: function (x) {
            $("#persId").val(x.persId);
            $("#nombres").val(x.persNombre);
            $("#apellidos").val(x.persApellido);
            $("#dni").val(x.persDni);
            $("#sexo").val(x.persSexo);
            $("#direccion").val(x.persDireccion);
        }
    });
    $("#staticBackdrop").modal('show');
}

$("#guardar").click(function () {
    $.ajax({
        url: "/persona/guardar",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            persId: $("#persId").val(),
            persNombre: $("#nombres").val(),
            persApellido: $("#apellidos").val(),
            persDni: $("#dni").val(),
            persSexo: $("#sexo").val(),
            persDireccion: $("#direccion").val()
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
            limpiar();
            listar();
        }
    });
    $("#staticBackdrop").modal('hide');
});

function limpiar() {
    $("#persId").val('');
    $("#nombres").val('');
    $("#apellidos").val('');
    $("#dni").val('');
    $("#sexo").val('');
    $("#direccion").val('');
}
/*
$("#botonModificar").click(function () {
    $.ajax({
        url: "/persona/modificar",
        type: 'PUT',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            persNombre: $("#editNombres").val(),
            persApellido: $("#editApellidos").val(),
            persDni: $("#editDni").val(),
            persSexo: $("#editSexo").val(),
            persDireccion: $("#editDireccion").val()
        }),
        cache: false,
        success: function (w) {
            var dialog = bootbox.dialog({
                message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro Modificado Correctamente.</p>',
                closeButton: false
            });
            setTimeout(function () {
                dialog.modal('hide');
            }, 1500);
            listar();
        }
    });
    $("#modalEditar").modal('hide');
});
*/

function eliminar(id) {
    bootbox.confirm({
        message: "¿Está seguro que desea eliminar el registro?",
        closeButton: false,
        title: "Eliminar",
        buttons: {
            confirm: {
                label: 'Eliminar',
                className: 'btn-primary'
            },
            cancel: {
                label: 'Cancelar',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/persona/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        var dialog = bootbox.dialog({
                            message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro Eliminado Correctamente.</p>',
                            closeButton: false
                        });
                        setTimeout(function () {
                            dialog.modal('hide');
                        }, 1500);
                        listar();
                    }
                });
            } else {
                /*
                var dialog = bootbox.dialog({
                    message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro no Eliminado.</p>',
                    closeButton: false
                });
                setTimeout(function () {
                    dialog.modal('hide');
                }, 1500);
                */
            }
        }
    });
}