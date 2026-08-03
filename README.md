# g11-tp2-2c-2024
## Grupo 11

* **Integrante 1** - [Matias Bagatto - 108812](https://github.com/mbagatto)
* **Integrante 2** - [Juan Balella - 110271](https://github.com/juanbalella20)
* **Integrante 3** - [Hector David Condori - 104518](https://github.com/DavidHC14)
* **Integrante 4** - [Valentin Gabriel Somoza - 109188](https://github.com/ValentinSomoza)
* **Integrante 5** - [Guiseppe Prieto Bonilla - 94188](https://github.com/giuspepo)

## Manual de ejecución

Este proyecto es una aplicación de escritorio **JavaFX** gestionada con **Maven**.

### Requisitos previos

* **JDK 23 o superior**
* **Maven 3.6+**

### Instalación de dependencias (macOS)

Si no tenés Java ni Maven instalados, podés instalarlos con Homebrew:

```bash
brew install openjdk maven
```

Como `openjdk` de Homebrew no se agrega automáticamente al `PATH`, hay que exportarlo antes de compilar/ejecutar:

```bash
export JAVA_HOME=/opt/homebrew/opt/openjdk
export PATH="/opt/homebrew/opt/openjdk/bin:/opt/homebrew/bin:$PATH"
```

### Ejecutar la aplicación

Desde la raíz del proyecto:

```bash
mvn clean javafx:run
```

Esto compila el proyecto y abre la ventana del juego (clase principal `view.Main`).

### Generar una imagen ejecutable (opcional)

El proyecto también está configurado para generar una imagen nativa autocontenida vía `jlink`:

```bash
mvn javafx:jlink
./target/myAplication/bin/app
```