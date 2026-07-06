package com.javiera.modelos;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 5, message = "El título debe tener al menos 5 caracteres.")
    private String titulo;
    
    @Size(min = 3, message = "El álbum debe tener al menos 3 caracteres.")
    private String album;
    
    @Size(min = 3, message = "El género debe tener al menos 3 caracteres.")
    private String genero;
    
    @Size(min = 3, message = "El idioma debe tener al menos 3 caracteres.")
    private String idioma;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="artista_id")
    private Artista artista;

    // CONSTRUCTOR VACÍO OBLIGATORIO PARA HIBERNATE
    public Cancion() {
    }

    @PrePersist
    protected void onCreate(){ this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate(){ this.updatedAt = new Date(); }

    // GETTERS Y SETTERS LIMPIOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }
    
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    
    public Artista getArtista() { return artista; }
    public void setArtista(Artista artista) { this.artista = artista; }
}