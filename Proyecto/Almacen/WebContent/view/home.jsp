<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventario</title>
</head>
<body>
	<%@include file="../view/component/head.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-6"></div>
			<div class="col">
			<!-- Buscador, busca en la tabla un elemento especifico -->
				<div class="input-group mb-3">
					<input type="text" list="browsers" class="form-control" placeholder="Buscar..."
						aria-label="Buscar un producto" aria-describedby="button-1">
					<datalist id="browsers">
						<c:forEach items="${listInv}" var="lo">
							<option value="${lo.cod}">${lo.nam}</option>
						</c:forEach>
					</datalist>
					<div class="input-group-prepend">
						<button class="btn btn-outline-secondary" type="button"
							id="button-1">Enviar</button>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
			<!-- table-1, Tabla de productos -->
				<table id="table-1" class="table table-bordered">
					<thead>
						<tr>
							<th style="width:10%;">Código</th>
							<th style="width:50%;">Nombre</th>
							<th style="width:10%;">Unidad</th>
							<th style="width:10%;">Precio</th>
							<th style="width:20%;">Acciones</th>
						</tr>
					</thead>
					<tbody id="content-table-1">
						<c:forEach items="${listInv}" var="li">
							<tr>
								<td>${li.cod}</td>
								<td>${li.nam}</td>
								<td>${li.uni}</td>
								<td>${li.pri}</td>
								<td><button type="button" class="btn btn-primary"
										data-toggle="modal" data-target=".modalrg"
										onclick="getDetails('${li.cod}')">Detalles</button>
									<button type="button" class="btn btn-info" data-toggle="modal"
										data-target=".modalrg" onclick="getEdit('${li.cod}')">Editar</button>
									<button type="button" class="btn btn-danger"
										data-toggle="modal" data-target=".modalrg"
										onclick="getDelete('${li.cod}')">Eliminar</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Botón para ingresar nuevo producto -->
				<button type="button" class="btn btn-primary" id="newreg"
					data-target=".modalrg" data-toggle="modal" onclick="newRegis()">
					<svg width="1em" height="1em" viewBox="0 0 16 16"
						class="bi bi-pencil" fill="currentColor"
						xmlns="http://www.w3.org/2000/svg">
  						<path fill-rule="evenodd"
							d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z" />
					</svg>
				</button>
			</div>
		</div>
	</div>
	<!-- Dialog -->
	<div class="modal fade modalrg" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<%@include file="../view/component/foot.jsp"%>
</body>
</html>