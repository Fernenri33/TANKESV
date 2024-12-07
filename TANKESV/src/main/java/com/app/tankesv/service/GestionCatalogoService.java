package com.app.tankesv.service;

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

import com.app.tankesv.model.Empresario;
import com.app.tankesv.model.GestionCatalogo;
import com.app.tankesv.repo.GestionCatalogoRepo;

@Service
public class GestionCatalogoService {

    @Autowired
    GestionCatalogoRepo gestionCatalogoRepo;

    private static final String upload_files = "src/main/resources/static/uploads/";

    // Obtener todos los datos de DB gestion_catalogo
    public List<GestionCatalogo> obtenerCatalogo(Empresario empresario) {
        return gestionCatalogoRepo.findByEmpresario(empresario);
    }

    // Obtener todos los datos para la gestión de catálogo
    public List<GestionCatalogo> obtenerCatalogoUsuario() {
        return gestionCatalogoRepo.findAll();
    }

    // Buscar productos por coincidencia parcial en el nombre
    public List<GestionCatalogo> obtenerProductoNombre(String nombreProducto) {
        return gestionCatalogoRepo.findByNombreProductoContainingIgnoreCase(nombreProducto);
    }

    // Agregar al catálogo un producto
    public void agregarProducto(String nombreProducto, String descripcionProducto, double precioProducto,
            int cantidadProducto, MultipartFile imagenProducto, Empresario empresario, RedirectAttributes redirectAttributes) throws IOException {

        GestionCatalogo producto = new GestionCatalogo();

        // Generar nombre único para la imagen
        String fileName = UUID.randomUUID().toString() + "_" + imagenProducto.getOriginalFilename();
        Path path = Paths.get(upload_files + fileName);
        Files.write(path, imagenProducto.getBytes());

        // Guardar la ruta de la imagen en el producto
        producto.setImagenProducto(fileName);

        // Configurar datos del producto
        producto.setNombreProducto(nombreProducto);
        producto.setDescripcionProducto(descripcionProducto);
        producto.setPrecioProducto(precioProducto);
        producto.setCantidadProducto(cantidadProducto);
        producto.setId_Empresario(empresario);

        // Guardar en el repositorio
        gestionCatalogoRepo.save(producto);
    }

    // Obtener producto por el ID
    public GestionCatalogo obtenerProductoID(Long id) {
        return gestionCatalogoRepo.findById(id).orElse(null);
    }

    // Editar o actualizar producto
    public void editarProducto(Long id, String nombreProducto, String descripcionProducto, double precioProducto,
            int cantidadProducto, MultipartFile imagenProducto, RedirectAttributes redirectAttributes)
            throws IOException {

        GestionCatalogo producto = obtenerProductoID(id);
        if (producto != null) {
            producto.setNombreProducto(nombreProducto);
            producto.setDescripcionProducto(descripcionProducto);
            producto.setPrecioProducto(precioProducto);
            producto.setCantidadProducto(cantidadProducto);

            if (!imagenProducto.isEmpty()) {
                String fileName = UUID.randomUUID().toString() + "_" + imagenProducto.getOriginalFilename();
                Path path = Paths.get(upload_files + fileName);
                Files.write(path, imagenProducto.getBytes());
                producto.setImagenProducto(fileName);
            }

            gestionCatalogoRepo.save(producto);
        }
    }

    // Eliminar producto por su ID
    public void eliminarProducto(Long id, RedirectAttributes redirectAttributes) {
        GestionCatalogo producto = obtenerProductoID(id);
        gestionCatalogoRepo.delete(producto);
    }
}
