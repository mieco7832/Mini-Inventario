package com.miec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.miec.domain.*;
import com.miec.models.ModelProducto;

@Controller
@RequestMapping("/")
public class InventarioController {

	@Autowired
	private InventarioDomian invd;
	ModelAndView mav = new ModelAndView();
	
	/* 	-Rediccionado por primera vez de index.jsp
	 *	-Redireciona a home.jsp, localizada en la carpeta view
	 *	-Lista los registros de Producto
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView getHome() {
		mav.setViewName("view/home");
		mav.addObject("listInv", invd.getProducto());
		return mav;
	}
	
	/*	-Petición de un nuevo registro
	 * 	-redirecciona a index.jsp
	 */
	@RequestMapping(value = "newReg", method = RequestMethod.POST)
	public ModelAndView setProducto(@RequestParam(value = "codigo") String codigo,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "unidad") String unidad,
			@RequestParam(value = "precio") String precio) {
		invd.setProducto(codigo, nombre, unidad, precio);
		mav.setViewName("index");
		return mav;
	}
	
	/*
	 *	-Petición de una lista de caracteristicas según el producto 
	 */
	@RequestMapping(value = "getDetails", method = RequestMethod.POST)
	public @ResponseBody String getCaracteristicas(@RequestParam(value = "code") String id) {
		String JSON = new Gson().toJson(invd.getCaracteristicaByCode(id));
		return JSON;
	}
	
	/*	
	 * 	-Petición para un nuevo registro de Caracteristica de un Producto
	 */
	@RequestMapping(value = "newOption", method = RequestMethod.POST)
	public @ResponseBody void setCaracteristicas(@RequestParam(value = "id") String codigo,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "option") String comentario) {
		invd.setCaracteristica(codigo, nombre, comentario);
	}
	
	/*
	 *	-Petición de un Producto por Id 
	 */
	@RequestMapping(value = "getProducto", method = RequestMethod.POST)
	public @ResponseBody ModelProducto getProducto(@RequestParam(value = "id") String code) {
		return invd.getProducto(code);
	}
	
	/*	-Petición de actualización de registro Producto
	 *	-Redireciona a index.jsp
	 */
	@RequestMapping(value = "editProd", method = RequestMethod.POST)
	public ModelAndView updateProducto(@RequestParam(value = "codigo") String codigo,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "unidad") String unidad,
			@RequestParam(value = "precio") String precio) {
		invd.updateProducto(codigo, nombre, unidad, precio);
		mav.setViewName("index");
		return mav;
	}
	
	/*
	 * 	-Petición de Caracteristica por Id 
	 */
	@RequestMapping(value = "getOpt", method = RequestMethod.POST)
	public @ResponseBody ModelProducto getOption(@RequestParam(value = "id") String id) {
		return invd.getOption(id);
	}
	
	/*
	 *	-Petición de actualización de caracteristica 
	 */
	@RequestMapping(value = "setEdition", method = RequestMethod.POST)
	public @ResponseBody void updateCaracteristica(@RequestParam(value = "code") String codigo,
			@RequestParam(value = "id") String id, @RequestParam(value = "name") String nombre,
			@RequestParam(value = "option") String comentario) {
		invd.updateCaracteristica(codigo, id, nombre, comentario);
	}
	
	/*	-Petición para eliminar un registro de Producto
	 *	-Redirecciona a index.jsp
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deleteProducto(@RequestParam (value = "id") String id) {
		invd.deteletProducto(id);
		mav.setViewName("index");
		return mav;
	}
	
	/*
	 *	-Petición para eliminar un registro de Caracteristica
	 */
	@RequestMapping(value = "deleteOpt", method = RequestMethod.POST)
	public @ResponseBody void deleteOpt(@RequestParam(value = "id") String id) {
		invd.deleteCaracteristica(id);
	}
}
