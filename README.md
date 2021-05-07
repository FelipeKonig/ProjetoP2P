<h3 align="center">Projeto P2P</h3>

<br />

---
<br />

# :clipboard: Indice

- [Demonstração](#Demonstracao) 
- [Sobre](#Sobre)
- [Como executar o projeto](#Como-executar)
- [Tecnologias Utilizadas](#Tecnologias-utilizadas)
- [Autor](#Autor)

## :camera: <a name="Demonstracao">Demonstração</a> 

![cmd](https://user-images.githubusercontent.com/49540283/117512636-5efb8900-af66-11eb-93ce-008f548fccfd.png)


## :pushpin: <a name="Sobre">Sobre</a>  

O projeto foi desenvolvido para executar duas threads simultaneamente, uma delas consiste em executar em segundo plano a parte do servidor na qual recebe requisições através de uma porta especifica, e a outra thread executa a parte do cliente na qual reenvia requisições recebidas ou mensagem digitada pelo usuário. A requisição enviada pelo cliente vai para outras duas portas fornecidas pelo arquivo chamado config.properties, o arquivo config.properties é definido na inicialização do programa, além de definir as portas de seus respectivos vizinhos, ela também fornece o id, node e porta do servidor do programa.

Para que os programas executados simultaneamente não entrarem em looping de requisições entre eles, a parte do servidor trata as requisições recebidas verificando se a mesma não foi enviada inicialmente pelo próprio servidor, ou se já reenviou para seus respectivos vizinhos. Após todos os servidores receberem a mensagem enviada pelo usuário em algum dos programas, todos eles ficam em estado de espera para enviar ou receber novas requisições.

## :black_nib: <a name="Como-executar">Como executar o projeto</a>  

Primeiramente, ir para o diretório do projeto para facilitar o uso dos comandos:
- cd C:...\ComunicacaoDescentralizada\src

Caso no diretório que contenha os arquivos .java do projeto não possuir os arquivos .class, é utilizado o comando javac para compilar os respectivos arquivos .class:
- javac Main.java

E por fim executar o programa definindo seu respectivo config.properties, por exemplo:
- java Main C:...\ComunicacaoDescentralizada\config2.properties

## :rocket: <a name="Tecnologias-utilizadas">Tecnologias utilizadas</a>  

- [Java](https://www.java.com/pt-BR/) > 10

## :smile: <a name="Autor">Autor</a>  

![eu](https://user-images.githubusercontent.com/49540283/117379724-7840fe80-aeae-11eb-87fb-54a79b44233d.jpg)
   
Feito com ☕ por Felipe Konig :wave: Entre em contato!

[![Facebook Badge](https://img.shields.io/badge/Facebook-Felipe%20Konig-blue)](https://www.facebook.com/felipe.konig.3/)
[![Twitter Badge](https://img.shields.io/badge/Twitter-Felipe%20Konig-blue)](https://twitter.com/FelipeKonig4) 
[![Linkedin Badge](https://img.shields.io/badge/LinkedIn-Felipe%20Konig-blue)](https://www.linkedin.com/in/felipe-konig-10bb8a190/) 
[![Gmail Badge](https://img.shields.io/badge/Gmail-lipekonig%40gmail.com-orange)](mailto:lipekonig@gmail.com)
