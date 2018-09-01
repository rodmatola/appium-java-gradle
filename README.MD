# Appium com Java e Gradle

Repositório com um modelo para rodar Appium com a linguagem Java utilizando o Gradle.

Este repositório é um backup meu de referência. NÃO basta baixá-lo para rodar. É preciso fazer mais instalações.

# Executar os testes

Para executar os testes de todas as features, na pasta onde se localiza o build.gradle, digite

```gradle runAndroidTests```

```gradle runIosTests```

para Android e iOS respectivamente.

Para executar cenários individuais, digite:

```gradle [runAndroid | runIos] -Dfeature="nome do arquivo sem o .feature" -Dtags="@tag"```

e para rodar uma feature completa

```gradle [runAndroidFeature | runIosFeature] -Dfeature="nome do arquivo sem o .feature"```

# Gerar relatório

Primeiramente é preciso instalar o [Allure](https://docs.qameta.io/allure/#_installing_a_commandline).

Após executar os testes, digite

```allure serve [caminho para a pasta dos arquivos para o relatório]```

que por padrão ficará na pasta allure-results, onde está o build.gradle. Se a pasta não for gerada automaticamente, você pode criá-la.