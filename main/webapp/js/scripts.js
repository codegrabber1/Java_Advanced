jQuery(document).ready(function($){
    switchForm();

    function switchForm(){
        $('#authTabs li:last-child a').tab('show');
    }


    $('.btnRegistration').on('click', function(e){
        e.preventDefault();
        var registerName = $('#register_name');
        var lastName = $('#lname');
        var registerEmail = $('#register_email');
        var registerPass = $('#register_pass');

        var name  = registerName .val();
        var lname  = lastName .val();
        var rPass  = registerPass .val();
        var rEmail  = registerEmail .val();

        if( name === '' || lname === '' || rPass === '' || rEmail === '') {
            registerName.addClass('error');
            lastName.addClass('error');
            registerEmail.addClass('error');
            registerPass.addClass('error');
            alert('All fields have to be filled');
        } else {
            if (registerName.hasClass('error') || lastName.hasClass('error') || registerEmail.hasClass('error') || registerPass.hasClass('error')) {
                registerName.removeClass('error');
                lastName.removeClass('error');
                registerEmail.removeClass('error');
                registerPass.removeClass('error');

                var registerGroup = {
                    registerName: registerName,
                    lastName: lastName,
                    registerEmail: registerEmail,
                    registerPass: registerPass

                };

                console.log(registerGroup);
                $.ajax({
                    type: 'post',
                    data: registerGroup,
                    url: 'RegistrationServlet',
                    success: function (data) {
                        if(data ) {
                            switchForm();
                        } else {
                            alert('Error sending data ...');
                        }
                    }
                });

            }
        }
    });

    $('.btnLogin').on('click', function(e){
        e.preventDefault();
        var login = $('#login');
        var pass  = $('#password');
        var loginVal  = login.val();
        var passVal  = pass.val();

        if( loginVal === '' || passVal === ''){
            login.addClass('error');
            pass.addClass('error');
            alert('Login and Password must be filled');
        } else {
            var loginGroup = {
             login: loginVal,
             pass : passVal
            };

            $.ajax({
               type: 'post',
               data: loginGroup,
               url: 'login',
               success: function (data) {
                   if(data ) {
                      window.location.href = data.destinationUrl;
                   } else {
                       alert('Error sending data ...');
                   }
               }
            });
        }
    });
}); // end ready