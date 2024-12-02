package com.app.tankesv.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    private String upload_files = "src/main/resources/static/uploads/";

    public void agregarProducto(String nombreProducto, String descripcionProducto, double precioProducto, int cantidadProducto, 
        MultipartFile imagenProducto, RedirectAttributes redirectAttributes) throws IOException {
        GestionCatalogo producto = new GestionCatalogo();

        if(!imagenProducto.isEmpty()){

            byte[] bytes = imagenProducto.getBytes();
            Path path = Paths.get(upload_files + imagenProducto.getOriginalFilename());
            Files.write(path, bytes);

            imagenProducto.transferTo(path);
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

            // Procesar nueva imagen si existe
            if (!imagenProducto.isEmpty()) {
                String uploadDir = System.getProperty("user.dir") + "/uploads";
                String filePath = uploadDir + "/" + imagenProducto.getOriginalFilename();
                File file = new File(filePath);
                imagenProducto.transferTo(file);
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

    public List<GestionCatalogo> obtenerCatalogo() {
        List<GestionCatalogo> catalogo = gestionCatalogoRepo.findAll();
        System.out.println(catalogo);  // Imprime los productos para verificar si se están obteniendo.
        return catalogo;
    }
    
    
}

