# ProjetoP2P

O projeto foi desenvolvido para executar duas threads simultaneamente, uma delas consiste em executar em segundo plano a parte do servidor na qual recebe requisições através de uma porta especifica, e a outra thread executa a parte do cliente na qual reenvia requisições recebidas ou mensagem digitada pelo usuário. A requisição enviada pelo cliente vai para outras duas portas fornecidas pelo arquivo chamado config.properties, o arquivo config.properties é definido na inicialização do programa, além de definir as portas de seus respectivos vizinhos, ela também fornece o id, node e porta do servidor do programa.

Para que os programas executados simultaneamente não entrarem em looping de requisições entre eles, a parte do servidor trata as requisições recebidas verificando se a mesma não foi enviada inicialmente pelo próprio servidor, ou se já reenviou para seus respectivos vizinhos. Após todos os servidores receberem a mensagem enviada pelo usuário em algum dos programas, todos eles ficam em estado de espera para enviar ou receber novas requisições.

Passo a passo para executar os programas através do terminal definindo seu respectivo config.properties:

Primeiramente, ir para o diretório do projeto para facilitar o uso dos comandos:
- cd C:...\ComunicacaoDescentralizada\src

Caso no diretório que contenha os arquivos .java do projeto não possuir os arquivos .class, é utilizado o comando javac para compilar os respectivos arquivos .class:
- javac Main.java

E por fim executar o programa definindo seu respectivo config.properties, por exemplo:
- java Main C:...\ComunicacaoDescentralizada\config2.properties
