package com.iftm.trabalho03.models.dtos;

import java.io.Serializable;

import com.iftm.trabalho03.models.Imovel;

public class ImovelDTO implements Serializable {
    private String id;
    private String endereco;
    private String tipoImovel;
    private Double area;
    private Double preco;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ImovelDTO [id=" + id + ", endereco=" + endereco + ", tipoImovel=" + tipoImovel + ", area=" + area
                + ", preco=" + preco + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((tipoImovel == null) ? 0 : tipoImovel.hashCode());
        result = prime * result + ((area == null) ? 0 : area.hashCode());
        result = prime * result + ((preco == null) ? 0 : preco.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImovelDTO other = (ImovelDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        if (tipoImovel == null) {
            if (other.tipoImovel != null)
                return false;
        } else if (!tipoImovel.equals(other.tipoImovel))
            return false;
        if (area == null) {
            if (other.area != null)
                return false;
        } else if (!area.equals(other.area))
            return false;
        if (preco == null) {
            if (other.preco != null)
                return false;
        } else if (!preco.equals(other.preco))
            return false;
        return true;
    }

    public ImovelDTO() {
    }

    public ImovelDTO(String id, String endereco, String tipoImovel, Double area, Double preco) {
        this.id = id;
        this.endereco = endereco;
        this.tipoImovel = tipoImovel;
        this.area = area;
        this.preco = preco;
    }

    public ImovelDTO(Imovel imovel) {
        this.id = imovel.getId().toString();
        this.endereco = imovel.getEndereco();
        this.tipoImovel = imovel.getTipoImovel();
        this.area = imovel.getArea();
        this.preco = imovel.getPreco();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
