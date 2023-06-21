# desafio_tecnico
## Atividade e Objetivo

Criar uma API Rest de um cadastro de Pessoas, utilizando Spring Boot e Java

### Requisitos:

Possuir ao menos os endpoints: GET(Buscar uma única Pessoa), GET (Busca paginada opção de filtro para retornar várias pessoas), POST, PUT, DELETE.

O cadastro de pessoa deve ter os campos: Id, Nome, CPF, Data de nascimento.

A pessoa deve possuir uma lista de contatos (relacionamento um para muitos) com os campos: Id, Nome, Telefone e Email.

Os dados devem ser persistidos utilizando um banco de dados relacional.

### Validações:

Todos os campos são obrigatórios, tanto da pessoa como do contato.

A Pessoa deve possuir ao menos um contato.

O CPF deve ser um CPF válido.

A Data de nascimento não pode ser uma data futura.

Validar sintaxe do email do contato.

### Requisitos técnicos:

Deverão ser criados testes unitários

Publicar o código em repositório público
_______________________________

#### Existe uma collection, titulada de "desafio_tecnico.postman_collection.json", onde o mesmo pode ser baixado e usado juntamente com a aplicação.
#### A publicar o código em repositório público não será possível, já que a aplicação usa o H2
