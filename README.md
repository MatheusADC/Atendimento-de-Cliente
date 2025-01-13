# <img src="https://github.com/user-attachments/assets/caabfdf0-0f9e-44a3-8200-c6579fe87887" alt="speech bubble" width="28"> Descrição
O Programa tem como fito o gerenciamento de um fila de atendimento de clientes, utilizando a linguagem de programação Java.

# <img src="https://github.com/user-attachments/assets/bbcdf893-ff78-464c-a248-75fc69288bf4" alt="Menu" width="28"> Tela do Menu
![image](https://github.com/user-attachments/assets/eb6b269c-333b-4a8f-bf10-b320e7bcbd46)

# <img src="https://github.com/user-attachments/assets/bcc13508-9dd5-494a-aee7-797736c6bf4c" alt="java icon" width="28"> Funcionalidades

## 1) Gerar senha
Solicita ao usuário seu nome, instancia o objeto **Cliente** e o coloca no ArrayList mostrando na tela o nome do usuário e a sua senha.

![image](https://github.com/user-attachments/assets/2b08a15c-d737-4db3-8726-c885263ed681)

## 2) Atendimento
Vai passar para a próxima senha, procurar no **ArrayList** o cliente que possui aquela senha, mostrar na tela a senha e o nome do cliente que será atendido
e, por fim, retirar o Cliente do vetor. Se não tiver essa senha, deve mostra uma mensagem na tela e passar para a próxima senha. 

Deve verificar se o vetor está vazio, nesse caso, mostrar na tela que não tem cliente para atender. Esse método deve usar os métodos já feitos na classe Cliente.

![image](https://github.com/user-attachments/assets/06ce0a39-3e1c-43f9-bf9b-2a8c33658135)

## 3) Sair da fila
Vai pedir ao Cliente a sua senha, procurar o cliente que possui aquela senha, retirá-lo do ArrayList e mostrar na tela que a senha (colocar o número) foi
removida. 

Se a senha não existir, mostra uma mensagem na tela. Esse método deve usar os métodos já feitos na classe Cliente.

![image](https://github.com/user-attachments/assets/543950c1-bdb1-48d8-ba89-1f7754c1cafd)

## 4) Mostrar todos os clientes não atendidos
Vai mostrar na tela a senha de todos os clientes que ainda não foram atendidos.

![image](https://github.com/user-attachments/assets/0bd4691c-3524-4063-b526-f3be6f4217ed)

## 5) Sair
O _break_ é acionado para fechar o programa.

