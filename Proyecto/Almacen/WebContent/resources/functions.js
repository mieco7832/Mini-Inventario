function newRegis() {
    let body = "<form action='newReg' method='post' id='form-1'><div class='row'><div class='col'>";
    body += "<div class='input-group mb-3'><input type='text' class='form-control' placeholder='Codigo' name='codigo'></div>";
    body += "</div><div class='col'>";
    body += "<div class='input-group mb-3'><input type='text' class='form-control' placeholder='Nombre' name='nombre'></div>";
    body += "</div></div>";
    body += "<div class='row'><div class='col'>";
    body += "<div class='input-group mb-3'><input type='text' class='form-control' placeholder='Unidad' name='unidad'></div>";
    body += "</div><div class='col'>";
    body += "<div class='input-group mb-3'><input type='number' class='form-control' placeholder='Precio' name='precio' min='0' step='.01'></div>";
    body += "</div></div><input type='submit' id='sub-1' value='Enviar' class='btn btn-primary form-control'></form>";
    $('.modal-title').text('Nuevo Registro');
    $('.modal-body').html(body);
}

function newOption() {
    if ($('input[name=opt_nombre]').val() !== '' && $('textarea[name=opt_option]').val() !== '') {
        $.ajax({
            url: "./newOption",
            method: "POST",
            data: {
                nombre: $('input[name=opt_nombre]').val(),
                option: $('textarea[name=opt_option]').val(),
                id: $('input[name=opt_code]').val()
            }
        }).done(function() {
            getDetails($('input[name=opt_code]').val());
        });
    }
}

function getDetails(id) {
    $('.modal-title').text('Detalles: ' + id);
    $.ajax({
        url: "./getDetails",
        method: "POST",
        data: {
            code: id
        }
    }).done(function(data) {
        let body = "";
        let i = 1;
        if (data !== "[]") {
            body += "<table id='table-2' class='table table-bordered'><thead><tr><th style='width:15%'># Registro</th><th style='width:15%'>Nombre</th><th style='width:40%'>Descripción</th><th style='width:30%'>Acciones</th></tr></thead><tbody style='heigth:250px;overflow:auto;'>";
            $.each(JSON.parse(data), function(index, obj) {
                body += "<tr><td>" + (i++) + "</td><td>" + obj.nac + "</td><td>" + obj.com + "</td><td>";
                body += "<button type='button' class='btn btn-info opt' onclick='getEditOpt(" + obj.id + ")'>Editar</button>";
                body += " <button type='button' class='btn btn-danger opt' onclick='getDeleteOpt(" + obj.id + ")'>Eliminar</button>";
                body += "</td></tr>";
            });
            body += "</tbody></table>";
        } else {
            body += "<h2>No hay registros aún.</h2>";
        }
        body += "<div class='row'><div class='col' id='col-01'>";
        body += "<div class='input-group mb-3'><input type='text' class='form-control' placeholder='Nombre' name='opt_nombre'></div>";
        body += "<div class='input-group mb-3'><textarea class='form-control' placeholder='Descripción' name='opt_option'></textarea></div>";
        body += "<div class='input-group mb-3'><input type='hidden' class='form-control' value='" + id + "' name='opt_code'></div>";
        body += "<input onclick='newOption()' type='button' id='sub-2' value='Enviar' class='btn btn-primary form-control'>";
        body += "</div></div>";
        $('.modal-body').html(body);
    });
}

function getEdit(id) {
    newRegis();
    $('#sub-1').val('Guardar');
    $('#form-1').attr("action", "./editProd").attr("method", "POST");
    $.ajax({
        url: "./getProducto",
        method: "POST",
        data: {
            id: id
        }
    }).done(function(data) {
		$('.modal-title').text("Editar: " +data.cod);
        $('input[name=codigo]').val(data.cod).attr("type", "hidden");
        $('input[name=nombre]').val(data.nam);
        $('input[name=unidad]').val(data.uni);
        $('input[name=precio]').val(data.pri);
    });
}

function getDelete(id) {
	let input = "<a href='./delete?id="+id+"' class='btn btn-danger'>Si</a>";
    $('.modal-title').text('Eliminar: '+id);
	$('.modal-body').html("¿Seguro que quieres eliminar este registro? " + input);
}

function getEditOpt(id) {
    $('#col-01').append("<button id='cancel-1' type='button' class='btn btn-info form-control' onclick='cancelEdit()'>Cancelar</button>");
    $('.opt').attr("disabled", "disabled");
	$('#sub-2').val("Editar").attr("onclick","editOption()");
	$.ajax({
		url: "./getOpt",
		method: "POST",
		data: {id:id}
	}).done(function (data){
		$('input[name=opt_nombre]').val(data.nac);
        $('textarea[name=opt_option]').text(data.com);
		$('#col-01').prepend("<p id='details'># <span>"+data.id+"</span></p>");
	});
}

function cancelEdit() {
    $('.opt').removeAttr("disabled");
    $('#cancel-1').remove();
	$('#sub-2').val("Guardar").attr("onclick","newOption()");
	$('input[name=opt_nombre]').val("");
    $('textarea[name=opt_option]').text("");
	$('#details').remove();
}

function editOption(){
	$.ajax({
		url: "./setEdition",
		method: "POST",
		data:{
			id: $('#details span').text(),
			name: $('input[name=opt_nombre]').val(),
			option: $('textarea[name=opt_option]').val(),
			code: $('input[name=opt_code]').val()
		}
	}).done(function (){
		getDetails($('input[name=opt_code]').val());
	});
}

function getDeleteOpt(id) {
	let a = $('input[name=opt_code]').val();
	let col = "<p>¿Seguro que quieres eliminar este detalle? </p><button id='delOpt' class='btn btn-danger'>Si</button>"; 
	col += " <button id='cancel-1' type='button' class='btn btn-info'>Cancelar</button>";
	$('.opt').attr("disabled", "disabled");
	$('#col-01').html(col);
	$('#cancel-1').attr("onclick","getDetails('"+a+"')");
	$('#delOpt').click(function (){
		$.ajax({
			url: "deleteOpt",
			method: "POST",
			data: {id:id}
		}).done(function (){
			getDetails(a);
		});
	});
}

$('.close').click(function (){
	$('.modal-body').html("");
	$('.modal-title').text("");
});

$('#button-1').click(function (){
	$("tr td:contains("+$('input[list=browsers]').val()+")").parent().css("background","yellow");
	$(window).scrollTop($("tr td:contains("+$('input[list=browsers]').val()+")").parent().offset().top);
	setTimeout(function(){
		$("tr td:contains("+$('input[list=browsers]').val()+")").parent().css("background","white");
	},3000);
});
