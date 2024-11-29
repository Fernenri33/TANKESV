package com.app.tankesv.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.model.GestionCatalogo;
import com.app.tankesv.repo.GestionCatalogoRepo;

@Service
public class GestionCatalogoService {

    @Autowired
    GestionCatalogoRepo gestionCatalogoRepo;

    public void agregarProducto(String nombreProducto, String descripcionProducto, double precioProducto, int cantidadProducto, 
                                MultipartFile imagenProducto, RedirectAttributes redirectAttributes) throws IOException {
        GestionCatalogo producto = new GestionCatalogo();

        // Procesar imagen
        if (!imagenProducto.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/uploads";
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) uploadPath.mkdirs();

            String filePath = uploadDir + "/" + imagenProducto.getOriginalFilename();
            File file = new File(filePath);
            imagenProducto.transferTo(file);

            producto.setImagenProducto(filePath);
        }

        // Configurar datos del producto
        producto.setNombreProducto(nombreProducto);
        producto.setDescripcionProducto(descripcionProducto);
        producto.setPrecioProducto(precioProducto);
        producto.setCantidadProducto(cantidadProducto);

        // Guardar en el repositorio
        gestionCatalogoRepo.save(producto);
        redirectAttributes.addFlashAttribute("message", "Producto agregado exitosamente.");
    }

    public void actualizarProducto(String nombreProducto, String descripcionProducto, 
    double precioProducto, int cantidadProducto, MultipartFile imagenProducto, 
    RedirectAttributes redirectAttributes) throws IOException{
        
        GestionCatalogo producto = gestionCatalogoRepo.findByNombreProducto(nombreProducto);

        if (producto != null) {
            // Actualizar datos del producto
            producto.setDescripcionProducto(descripcionProducto);
            producto.setPrecioProducto(precioProducto);
            producto.setCantidadProducto(cantidadProducto);

            // Procesar nueva imagen si existe
            if (!imagenProducto.isEmpty()) {
                String uploadDir = System.getProperty("user.dir") + "/uploads";
                String filePath = uploadDir + "/" + imagenProducto.getOriginalFilename();
                File file = new File(filePath);
                imagenProducto.transferTo(file);

                producto.setImagenProducto(filePath);
            }

            // Guardar cambios
            gestionCatalogoRepo.save(producto);
            redirectAttributes.addFlashAttribute("message", "Producto actualizado exitosamente.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Producto no encontrado.");
        }
    }

    public void eliminarProducto(String nombreProducto, RedirectAttributes redirectAttributes) {
        GestionCatalogo producto = gestionCatalogoRepo.findByNombreProducto(nombreProducto);

        if (producto != null) {
            gestionCatalogoRepo.delete(producto);
            redirectAttributes.addFlashAttribute("message", "Producto eliminado exitosamente.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Producto no encontrado.");
        }
    }
}

