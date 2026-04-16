# 🚀 UrlShorten-Backend | Encurtador de URLs Resiliente

Este projeto é uma API REST desenvolvida em **Java 21** e **Spring Boot 3**, projetada para transformar URLs longas em links curtos e gerenciáveis. A arquitetura foi pensada para ser leve, escalável e fácil de manter, aplicando padrões de **System Design** e **Clean Code**.

## 🛠️ Stack Tecnológica

| Tecnologia | Finalidade |
| :--- | :--- |
| **Java 21** | Linguagem principal (Records e Modern Java) |
| **Spring Boot 3** | Framework core e Servidor Web |
| **Spring Data JPA** | Persistência de dados e ORM |
| **PostgreSQL** | Banco de dados relacional robusto |
| **Docker** | Containerização da infraestrutura de dados |
| **Maven** | Gestão de dependências e automação de build |

## 🏗️ Decisões de Arquitetura

Como futuro Engenheiro de Software, priorizei os seguintes pilares:
* **Princípio da Responsabilidade Única (SRP):** Divisão clara entre Controllers, Services e Repositories.
* **Infraestrutura como Código:** Uso de `docker-compose` para garantir que o banco de dados suba com um único comando.
* **Resiliência:** Tratamento de links expirados ou inexistentes com os status HTTP corretos (**302 Found** e **404 Not Found**).
* **Segurança de Configuração:** Uso de variáveis de ambiente (`.env`) para proteger credenciais sensíveis.

## 🔌 Endpoints da API

### **1. Criar Link Encurtado**
* **Método:** `POST /`
* **Payload:**
```json
{
  "url": "[https://www.google.com](https://www.google.com)"
}
```
* **Resposta:** Retorna o código único da URL encurtada.

### **2. Redirecionamento**
* **Método:** `GET /{id}`
* **Ação:** Redireciona automaticamente para a URL original.

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/matheusdelmones/UrlShorten-Backend.git](https://github.com/matheusdelmones/UrlShorten-Backend.git)
   ```
2. **Configure o ambiente:**
   * Crie um arquivo `.env` na raiz com as credenciais do banco.
3. **Suba o Banco de Dados:**
   ```bash
   docker-compose up -d
   ```
4. **Inicie a aplicação:**
   ```bash
   mvn spring-boot:run
   ```
---
> Projeto desenvolvido por **Matheus Delmones de Sousa** como parte do portfólio de Engenharia de Software.
```
