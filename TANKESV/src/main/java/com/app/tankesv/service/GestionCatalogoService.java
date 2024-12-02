package com.app.tankesv.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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

    //Obtener todos los datos de DB gestion_catalogo
    public List<GestionCatalogo> obtenerCatalogo() {
        return gestionCatalogoRepo.findAll();
    }

    private String upload_files = "src/main/resources/static/uploads/";

    public void agregarProducto(String nombreProducto, String descripcionProducto, double precioProducto, int cantidadProducto, 
        MultipartFile imagenProducto, RedirectAttributes redirectAttributes) throws IOException {
        GestionCatalogo producto = new GestionCatalogo();

        if (!imagenProducto.isEmpty()) {
            // Crear directorio si no existe
            File directorio = new File(upload_files);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
    
            // Generar nombre único para la imagen
            String fileName = UUID.randomUUID().toString() + "_" + imagenProducto.getOriginalFilename();
            Path path = Paths.get(upload_files + fileName);
            Files.write(path, imagenProducto.getBytes());
    
            // Guardar la ruta de la imagen en el producto
            producto.setImagenProducto(fileName);
        }
    
        // Configurar datos del producto
        producto.setNombreProducto(nombreProducto);
        producto.setDescripcionProducto(descripcionProducto);
        producto.setPrecioProducto(precioProducto);
        producto.setCantidadProducto(cantidadProducto);
    
        // Guardar en el repositorio
        gestionCatalogoRepo.save(producto);
    }
    public void actualizarProducto(int id, String nombreProducto, String descripcionProducto, 
    double precioProducto, int cantidadProducto, MultipartFile imagenProducto, 
    RedirectAttributes redirectAttributes) throws IOException{
        
        GestionCatalogo producto = gestionCatalogoRepo.findById(id);

        if (producto != null) {
            // Actualizar datos del producto
            producto.setNombreProducto(nombreProducto);
            producto.setDescripcionProducto(descripcionProducto);
            producto.setPrecioProducto(precioProducto);
            producto.setCantidadProducto(cantidadProducto);

            if (!imagenProducto.isEmpty()) {
                // Crear directorio si no existe
                File directorio = new File(upload_files);
                if (!directorio.exists()) {
                    directorio.mkdirs();
                }
        
                // Generar nombre único para la imagen
                String fileName = UUID.randomUUID().toString() + "_" + imagenProducto.getOriginalFilename();
                Path path = Paths.get(upload_files + fileName);
                Files.write(path, imagenProducto.getBytes());
        
                // Guardar la ruta de la imagen en el producto
                producto.setImagenProducto(fileName);
            }

            // Guardar cambios
            gestionCatalogoRepo.save(producto);
            redirectAttributes.addFlashAttribute("message", "Producto actualizado exitosamente.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Producto no encontrado.");
        }
    }

    public void eliminarProducto(int id, RedirectAttributes redirectAttributes) {
        GestionCatalogo producto = gestionCatalogoRepo.findById(id);
        if (producto != null) {
            gestionCatalogoRepo.delete(producto);
            redirectAttributes.addFlashAttribute("message", "Producto eliminado exitosamente.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Producto no encontrado.");
        }
    }
}

