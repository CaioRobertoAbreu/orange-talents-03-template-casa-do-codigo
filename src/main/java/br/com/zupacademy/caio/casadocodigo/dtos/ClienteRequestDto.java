package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Cliente;
import br.com.zupacademy.caio.casadocodigo.model.Estado;
import br.com.zupacademy.caio.casadocodigo.model.Pais;
import br.com.zupacademy.caio.casadocodigo.validation.custom.CPF_CNPJ;
import br.com.zupacademy.caio.casadocodigo.validation.custom.NotDuplicatedField;
import br.com.zupacademy.caio.casadocodigo.validation.custom.ObjectExists;
import br.com.zupacademy.caio.casadocodigo.validation.custom.VerifyIfMandatory;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@VerifyIfMandatory(domain = Estado.class, fieldName = "pais_id")
public class ClienteRequestDto {

    @NotBlank
    @Email
    @NotDuplicatedField(domain = Cliente.class, field = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CPF_CNPJ
    @NotDuplicatedField(domain = Cliente.class, field = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ObjectExists(domain = Pais.class, fieldName = "id")
    private Long pais;
    @ObjectExists(domain = Estado.class, fieldName = "id")
    private Long estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequestDto(String email, String nome, String sobrenome, String documento,
                             String endereco, String complemento, String cidade, String telefone,
                             String cep) {

        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }


    public static Cliente toModel(ClienteRequestDto clienteRequestDto, Pais pais) {

        return new Cliente(clienteRequestDto.getEmail(), clienteRequestDto.getNome(),
                clienteRequestDto.getSobrenome(), clienteRequestDto.getDocumento(),
                clienteRequestDto.getEndereco(), clienteRequestDto.getComplemento(),
                clienteRequestDto.getCidade(), pais, clienteRequestDto.getTelefone(),
                clienteRequestDto.getCep());
    }
}
