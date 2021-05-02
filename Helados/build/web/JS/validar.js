/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarn(e){
    var teclado=(document.all)?e.keyCode:e.which;
    if(teclado==8)return true;

    var patron=/[0-9\d .]/;

    var prueba=String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarRegistro(formulario){
    //validar longitud nombre
    if(formulario.nombre.value.length < 3){
        alert("Por favor escribe tres carácteres o más en tu nombre");
        formulario.nombre.focus();
        return false;
    }

    //validar longitud apellido paterno
    if(formulario.appat.value.length < 3){
        alert("Por favor escribe tres carácteres o más en tu apellido paterno");
        formulario.appat.focus();
        return false;
    }

    //validar longitud apellido paterno
    if(formulario.apmat.value.length < 3){
        alert("Por favor escribe tres carácteres o más en tu apellido materno");
        formulario.apmat.focus();
        return false;
    }
    
    //obtencion de datos de los input
    var checkOk="QWERTYUIOPASDFGHJKLÑZXCVBNM+"+"qwertyuiopasdfghjklñzxcvbnm"+" ";
    var checkNombre=formulario.nombre.value;
    var checkAppat=formulario.appat.value;
    var checkApmat=formulario.apmat.value;
    var allValid=true;
    
    
    
    //validar nombre
    for(var i=0; i<checkNombre.length;i++){
        var ch=checkNombre.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    if(!allValid){
        alert("Escribe solo letras en tu nombre");
        formulario.nombre.focus();
        return false;
    }

    //validar apellido paterno
    for(var i=0; i<checkAppat.length;i++){
        var ch=checkAppat.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    if(!allValid){
        alert("Escribe solo letras en tu apellido paterno");
        formulario.appat.focus();
        return false;
    }

    //validar apellido materno
    for(var i=0; i<checkApmat.length;i++){
        var ch=checkApmat.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    if(!allValid){
        alert("Escribe solo letras en tu apellido materno");
        formulario.apmat.focus();
        return false;
    }
    
    //validar edad
    var checkOk="1234567890";
    var checkEdad=formulario.edad.value;
    var allValid=true;
    
    for(var i=0; i<checkEdad.length;i++){
        var ch=checkEdad.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    
    if(checkEdad<0 || checkEdad>122){
        alert("Ingresa una edad válida entre 1 a 122 años");
        return false;
    }
}

function validarDatosA(formulario){
    //validar longitud nombre
    if(formulario.nombrea.value.length < 3){
        alert("Escriba tres carácteres o más en tu nombre");
        formulario.nombrea.focus();
        return false;
    }

    //validar longitud apellido paterno
    if(formulario.appata.value.length < 3){
        alert("Escriba tres carácteres o más en tu apellido paterno");
        formulario.appata.focus();
        return false;
    }

    //validar longitud apellido paterno
    if(formulario.apmata.value.length < 3){
        alert("Escriba tres carácteres o más en tu apellido materno");
        formulario.apmata.focus();
        return false;
    }
    
    //obtencion de datos de los input
    var checkOk="QWERTYUIOPASDFGHJKLÑZXCVBNM+"+"qwertyuiopasdfghjklñzxcvbnm"+" ";
    var checkNombre=formulario.nombrea.value;
    var checkAppat=formulario.appata.value;
    var checkApmat=formulario.apmata.value;
    var allValid=true;
    
    
    
    //validar nombre
    for(var i=0; i<checkNombre.length;i++){
        var ch=checkNombre.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    if(!allValid){
        alert("Escribe solo letras en tu nombre");
        formulario.nombrea.focus();
        return false;
    }

    //validar apellido paterno
    for(var i=0; i<checkAppat.length;i++){
        var ch=checkAppat.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    if(!allValid){
        alert("Escribe solo letras en tu apellido paterno");
        formulario.appata.focus();
        return false;
    }

    //validar apellido materno
    for(var i=0; i<checkApmat.length;i++){
        var ch=checkApmat.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    if(!allValid){
        alert("Escribe solo letras en tu apellido materno");
        formulario.apmata.focus();
        return false;
    }
    
    //validar edad
    var checkOk="1234567890";
    var checkEdad=formulario.edada.value;
    var allValid=true;
    
    for(var i=0; i<checkEdad.length;i++){
        var ch=checkEdad.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    
    if(checkEdad<0 || checkEdad>122){
        alert("Ingresa una edad válida entre 1 a 122 años");
        return false;
    }

}

function validarIDE(formulario){
    var checkOk="1234567890";
    var idE=formulario.ideliminar.value;
    var allValid=true;
    
    for(var i=0; i<idE.length;i++){
        var ch=idE.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    
    if(idE<0){
        alert("Ingrese un ID válido");
        return false;
    }
}

function validarIDA(formulario){
    var checkOk="1234567890";
    var idA=formulario.idactualizar.value;
    var allValid=true;
    
    for(var i=0; i<idA.length;i++){
        var ch=idA.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    
    if(idA<0){
        alert("Ingrese un ID válido");
        return false;
    }
}
