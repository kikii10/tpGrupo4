package com.unla.tpGrupo4.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.unla.tpGrupo4.entities.Compra;
import com.unla.tpGrupo4.repositories.ICompraRepository;

public class CompraService {
	@Autowired
    private ICompraRepository compraRepository;
   
     @Autowired
    public CompraService(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
        
    }
    
   public List<Compra> verCompras() {
        return compraRepository.findAll();
    }
   
    
    public void crearCompra(Compra m) {
        compraRepository.save(m);

    }
   
    public void borrarCompra(int id) {
        compraRepository.deleteById(id);
    }

  
    public Compra buscarCompra(int id) {
        
        return compraRepository.findById(id).orElse(null);
    }

   
    public void modificarCompra(int id, Compra compra) {
        
    }
    
   /* public List<Compra> findCompras() {
        return compraRepository.findCompra();
    }
		*/
}
