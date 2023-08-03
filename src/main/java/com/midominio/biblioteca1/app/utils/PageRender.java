package com.midominio.biblioteca1.app.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	// Datos básicos: url y Page que recibe
	private String url;
	private Page<T> page;
	
	// Datos derivados: páginas, elementos por página y página actual
	private int totalPaginas;
	private int numPagAMostrar;
	private int paginaActual;
	
	
	// Lista de todas las páginas
	
	List<PageItem> paginas;
	
	// Constructor
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		numPagAMostrar = 6;
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;
		
		int desde, hasta;
		if (totalPaginas <= numPagAMostrar) {
			desde = 1;
			hasta = totalPaginas;					
		} else {
			if(paginaActual <= numPagAMostrar / 2) {
				desde = 1;
				hasta = numPagAMostrar;
			} else if(paginaActual >= totalPaginas - numPagAMostrar / 2) {
				desde = totalPaginas - numPagAMostrar + 1;
				hasta = numPagAMostrar;
			} else {
				desde = paginaActual - numPagAMostrar / 2;
				hasta = numPagAMostrar;
			}
		}
		for(int i=0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde + i));
		}
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();		
	}
}