// creamos un evento
$(document).ready(function () {
    $("#search").keyup(function () {
        _this = this;
        // muestra la fila 
        $.each($("#example tbody tr"), function () {
            if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                $(this).hide();
            else
                $(this).show();
        });
    });
    

   
    
});