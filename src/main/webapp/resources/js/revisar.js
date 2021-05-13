function validarFormualrio() {

    $('.alert').remove();

    var codig_xp = $('#codig_xp').val(),
        nombre = $('#nombre').val(),
        apellidoP = $('#apellidoP').val(),
        apellidoM = $('#apellidoM').val(),
        selecto = $('#selecto').val(),
        dni = $('#dni').val(),
        correoP = $('#correoP').val(),
        telefono = $('#telefono').val(),
        celular = $('#celular').val(),
        fechaNacer = $('#fechaNacer').val(),
        correoContractor = $('#correoContractor').val(),
        correoEmpresa = $('#correoEmpresa').val(),
        tipoContrato = $('#tipoContrato').val(),
        fechaIngreso = $('#fechaIngreso').val();
        
    


    if (codig_xp == "" || codig_xp == null) {

        cambiarColor("codig_xp");

        mostrarAlert("Campo obliglatorio, Ingrese codig_xp");
        return false;
    } else {
        var expresion = /^[A-Za-z0-9]+$/;
        if (!expresion.test(codig_xp)) {

            cambiarColor("codig_xp");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }



    if (nombre == "" || nombre == null) {

        cambiarColor("nombre");

        mostrarAlert("Campo obliglatorio, Ingrese nombre");
        return false;
    } else {
        var expresion = /^([a-zA-ZÁÉÍÓÚñáéíóú]{1,}[\s]*)+$/;
        if (!expresion.test(nombre)) {

            cambiarColor("nombre");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }



    if (apellidoP == "" || apellidoP == null) {

        cambiarColor("apellidoP");

        mostrarAlert("Campo obliglatorio, Ingrese apellido Paterno");
        return false;
    } else {
        var expresion = /^([a-zA-ZÁÉÍÓÚñáéíóú]{1,}[\s]*)+$/;
        if (!expresion.test(apellidoP)) {

            cambiarColor("apellidoP");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }

    if (apellidoM == "" || apellidoM == null) {

        cambiarColor("apellidoM");

        mostrarAlert("Campo obliglatorio, Ingrese apellido Materno");
        return false;
    } else {
        var expresion = /^([a-zA-ZÁÉÍÓÚñáéíóú]{1,}[\s]*)+$/;
        if (!expresion.test(apellidoM)) {

            cambiarColor("apellidoM");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }

    if (selecto == 0 ||selecto==null ) {

        cambiarColor("selecto");
        mostrarAlert("Campo obliglatorio, Seleccione una opcion ");
        return false;
    } 

    if (dni == "" || dni == null) {

        cambiarColor("dni");

        mostrarAlert("Campo obliglatorio, Ingrese dni");
        return false;
    } else {
        var expresion = /^[A-Za-z0-9]+$/;
        if (!expresion.test(dni)) {

            cambiarColor("dni");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }

    if (correoP == "" || correoP == null) {

        cambiarColor("correoP");

        mostrarAlert("Campo obliglatorio, Ingrese correo Personal");
        return false;
    } else {
        var expresion = /^[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}$/;
        if (!expresion.test(correoP)) {

            cambiarColor("correoP");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }

    if (telefono == "" || telefono == null) {

        cambiarColor("telefono");
        mostrarAlert("Campo obliglatorio, Ingrese telefono");
        return false;
    } else {
        var expresion = /^[0-9]{7}$/;
        if (!expresion.test(telefono)) {

            cambiarColor("telefono");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }

    if (celular == "" || celular == null) {

        cambiarColor("celular");
        mostrarAlert("Campo obliglatorio, Ingrese celular");
        return false;
    } else {
        var expresion = /^[0-9]{9}$/;
        if (!expresion.test(celular)) {

            cambiarColor("celular");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }


    if (fechaNacer == "" || fechaNacer == null) {

        cambiarColor("fechaNacer");
        mostrarAlert("Campo obliglatorio, Ingrese fechaNacer");
        return false;
    }/* else {
        var expresion = /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
        if (!expresion.test(fechaNacimiento)) {

            cambiarColor("fechaNacimiento");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }*/


    if (correoContractor == "" || correoContractor == null) {

        cambiarColor("correoContractor");
        mostrarAlert("Campo obliglatorio, Ingrese correoContractor");
        return false;
    } else {
        var expresion = /^[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}$/;
        if (!expresion.test(correoContractor)) {

            cambiarColor("correoContractor");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }

    if (correoEmpresa == "" || correoEmpresa == null) {

        cambiarColor("correoEmpresa");
        mostrarAlert("Campo obliglatorio, Ingrese correoEmpresa");
        return false;
    } else {
        var expresion = /^[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}$/;
        if (!expresion.test(correoEmpresa)) {

            cambiarColor("correoEmpresa");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }

    if (tipoContrato == "" || tipoContrato == null) {

        cambiarColor("tipoContrato");
        mostrarAlert("Campo obliglatorio, Ingrese tipoContrato");
        return false;
    } else {
        var expresion = /^([a-zA-ZÁÉÍÓÚñáéíóú]{1,}[\s]*)+$/;
        if (!expresion.test(tipoContrato)) {

            cambiarColor("tipoContrato");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }

    if (fechaIngreso == "" || fechaIngreso == null) {

        cambiarColor("fechaIngreso");
        mostrarAlert("Campo obliglatorio, Ingrese fechaIngreso");
        return false;
    }/* else {
        var expresion = /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
        if (!expresion.test(fechaIngreso)) {

            cambiarColor("fechaIngreso");
            mostrarAlert("No se permiten caracteres especiales");
            return false;
        }
    }*/




    $('form').submit();
    return true;


}

$('input').focus(function () {
    $('alert').remove();
    colorDefault('codig_xp');
    colorDefault('nombre');
    colorDefault('apellidoP');
    colorDefault('apellidoM');
    colorDefault('dni');
    colorDefault('fechaNacer');
    colorDefault('correoP');
    colorDefault('telefono');
    colorDefault('celular');
    colorDefault('correoContractor');
    colorDefault('correoEmpresa');
    colorDefault('tipoContrato');
    colorDefault('fechaIngreso');
    
    

});

$('select').focus(function(){
    $('alert').remove();
    colorDefault('selecto');
})

function colorDefault(dato) {
    $('#' + dato).css({
        border: "2px solid #59F4DF"
    });
}

function cambiarColor(dato) {
    $('#' + dato).css({
        border: "2px solid #FF3933"
    });
}

function mostrarAlert(texto) {
    $('#codi').before('<div class="alert">Error: ' + texto + '</div>');
}