const formulario = document.getElementById('Registro-Formu');

formulario.addEventListener('submit', evento => {
    evento.preventDefault();
    if(validarFormulario()){
    formulario.submit();
    }

});

function mostrarError(campo, mensaje){
    const campoError = document.getElementById(`${campo}-error`);
    campoError.innerText = mensaje;
}

function validarEmail(email) {
    const expresionesRegulares = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return expresionesRegulares.test(email);
}

function eliminarError(campo){
    const campoError = document.getElementById(`${campo}-error`);
    campoError.innerText = '';
}

function validarFormulario() {
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const email = document.getElementById('email').value;
    const contraseña = document.getElementById('contraseña').value;

    if (nombre === '') {
        mostrarError('nombre', 'Por favor, ingresa tu nombre');
        return false;
    }else{
        eliminarError('nombre');
    }
    if (apellido === '') {
        mostrarError('apellido', 'Por favor, ingresa tu apellido');
        return false;
    }
    else{
        eliminarError('apellido');
    }
    if (email === '') {
        mostrarError('email', 'Por favor, ingresa tu email');
        return false;
    }
    else{
        eliminarError('email');
    }
    if (!validarEmail(email)) {
        mostrarError('email', 'Por favor, ingresa tu email');
        return false;
    }
    else{
        eliminarError('email');
    }
    if (contraseña === '') {
        mostrarError('contraseña', 'Por favor, ingrese su contraseña');
        return false;
    }
    else{
        eliminarError('contraseña');
    }

   return true;
}