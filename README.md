# Programação Fortificada - Plataforma

Essa aplicação é a plataforma do projeto Programação Fortificada, que tem como objetivo ensinar programação para todos de forma lúdica e divertida.

# Iniciando projeto

### Documentação relacionada

Para mais referências, acesse a documentação do projeto em: https://github.com/m-carneiro/pf-platform/wiki

### Guia

Temos 3 jeitos de rodar o projeto, sendo eles:

- Rodar o projeto localmente, via **gradle**:

```bash
  ./gradlew clean build
```

```bash
  ./gradlew bootRun
```

- Rodar o projeto localmente, via **docker-compose**:

```bash
  docker-compose up -d
```

- Rodar o projeto localmente, via **docker**:

```bash
  docker build -t pf-platform .
```

```bash
  docker run -p 8080:8080 pf-platform
```

### Links adicionais

Referências adicionais para o projeto:
