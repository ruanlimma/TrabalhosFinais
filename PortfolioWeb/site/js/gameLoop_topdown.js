//Criando o canvas
var canvas = document.createElement("canvas");
//Definindo um contexto em 2D
var ctx = canvas.getContext("2d");
//Largura e Altura do Canvas
canvas.width = 400;
canvas.height = 400;
//Canvas é filho do BODY, ou seja, será criado dentro da tag BODY
document.getElementById("artigo").appendChild(canvas);


//Background
var bgReady = false;
var bgImage = new Image();
bgImage.onload = function(){
	bgReady = true;
	};
bgImage.src = "./image/background.jpg";

//Jogador
var heroReady = false;
var heroImage = new Image();
heroImage.onload = function(){
	heroReady = true;
	};
heroImage.src = "./image/player.png";

//Monstro
var monsterReady = false;
var monsterImage = new Image();
monsterImage.onload = function(){
	monsterReady = true;
	};
monsterImage.src = "./image/monster.png";

//Monstro2
var monsterReady2 = false;
var monsterImage2 = new Image();
monsterImage2.onload = function(){
	monsterReady2 = true;
	};
monsterImage2.src = "./image/monster2.png";

//Objetos do Jogo
var hero ={
	speed: 256
};
var monster = {};
var monster2 = {};
//Quantidade de monstros capturados
var monsterCought = 0;
//Controlando pelo teclado
var keysDown = {};

var acabouTempo = 5000;
var nivel = 0;

//Manipulador de evento do teclado, verifica o que esta acontecendo com o teclado
addEventListener("keydown", function (e) {
	keysDown[e.keyCode] = true;
}, false);

addEventListener("keyup", function (e) {
	delete keysDown[e.keyCode];
}, false);

//Resetando o jogo
var reset = function (){
	//O player é criado no meio da tela(layout)
	hero.x = canvas.width / 2;
	hero.y = canvas.height / 2;
	//Criação do monstro de forma randômica
	monster.x = 32 + (Math.random() * (canvas.width - 64));
	monster.y = 32 + (Math.random() * (canvas.height - 64));

	//Criação do monstro de forma randômica
	monster2.x = 32 + (Math.random() * (canvas.width - 64));
	monster2.y = 32 + (Math.random() * (canvas.height - 64));

	keysDown = {};
}

//Controle de Direções
var update = function (modifier) {
	if (38 in keysDown){//Cima
		hero.y -= hero.speed * modifier;
	}
	if (40 in keysDown){//Baixo
		hero.y += hero.speed * modifier;
	}
	if (37 in keysDown){//Esquerda
		hero.x -= hero.speed * modifier;
	}
	if (39 in keysDown){//Direita
		hero.x += hero.speed * modifier;
	}

	//Colisão
	if(hero.x <= (canvas.width-398)){
		
		hero.x = (canvas.width - 4);
		hero.y = hero.y;
		
	}
	
	if(hero.x >= (canvas.width-2)){
		
		hero.x = (canvas.width - 396);
		hero.y = hero.y;
		
	}
	
	if(hero.y <= (canvas.height-398)){
		
		hero.y = (canvas.height - 4);
		hero.x = hero.x;
		
	}
	
	if(hero.y >= (canvas.height-2)){
		
		hero.y = (canvas.height - 396);
		hero.x = hero.x;
		
	}
		
	

	//Colisão
	if(hero.x <= (monster.x + 32) && monster.x <= (hero.x + 32) && hero.y <= (monster.y + 32) && monster.y <= (hero.y + 32)){
		++monsterCought;
		reset();
	}
	
	//Colisão
	if(hero.x <= (monster2.x + 32) && monster2.x <= (hero.x + 32) && hero.y <= (monster2.y + 32) && monster2.y <= (hero.y + 32)){
		--monsterCought;
		reset();
	}

};

//Desenhar na Tela
var render = function (){
	if(bgReady){
		ctx.drawImage(bgImage, 0, 0);
	}
	if(heroReady){
		ctx.drawImage(heroImage, hero.x, hero.y);
	}
	if(monsterReady){
		ctx.drawImage(monsterImage, monster.x, monster.y);
	}

		if(monsterReady2){
		ctx.drawImage(monsterImage2, monster2.x, monster2.y);
	}

	//Placar
	ctx.fillStyle = "rgb(250, 250, 250)";
	ctx.font = "22px Verdana";
	ctx.textAlign= "left";
	ctx.textBaseline = "top";
	ctx.fillText("Capturados: " + monsterCought, 32, 32);

	ctx.fillStyle = "rgb(250, 250, 250)";
	ctx.font = "22px Verdana";
	ctx.textAlign= "left";
	ctx.textBaseline = "top";
	ctx.fillText("Tempo: " + acabouTempo, 32, 350	);
};


function acabou() {


	if (acabouTempo < 0 ){

		switch(nivel) {


	   		case 0:
	   				if(monsterCought > 10){
						nivel = nivel +1;
			    		window.alert("Voce capturou: " + monsterCought + " e avançou pro nivel 2");
				    	reset();
				    	var then = Date.now();
				    	monsterCought = 0;
				    	acabouTempo = 4000;		
		        		break;      
	   				}
	   				else{
	   					nivel = 0;
			    		window.alert("Voce capturou: " + monsterCought + " e perdeu o jogo.");
				    	reset();
				    	var then = Date.now();
				    	monsterCought = 0;
				    	acabouTempo = 5000;
				    	break;
	   				}

	    		
    
	       	case 1:

		       	if(monsterCought > 15){
					nivel = nivel +1;
		    		window.alert("Voce capturou: " + monsterCought + " e avançou pro nivel 3");
			    	reset();
			    	clearInterval(main);
			    	var then = Date.now();
			    	monsterCought = 0;
			    	acabouTempo = 3500;
			    	break;   
		       	}	    		 
		    	
		    	else{
		    		nivel = 0;
		    		window.alert("Voce capturou: " + monsterCought + " e perdeu o jogo.");
			    	reset();
			    	clearInterval(main);
			    	var then = Date.now();
			    	monsterCought = 0;
			    	acabouTempo = 5000;
			    	break;    
		    	}
	    		
	    	
	    	case 2:

	    		if (monsterCought > 20){
	    			nivel = nivel +1;
		    		window.alert("Voce capturou: " + monsterCought + " e venceu o jogo");
			    	reset();
			    	clearInterval(main);
			    	var then = Date.now();
			    	monsterCought = 0;
			    	acabouTempo = 5000;
			    	break;    
	    		}
	    			    	
		    	else{
					nivel = 0;
		    		window.alert("Voce capturou: " + monsterCought + " e perdeu o jogo.");
			    	reset();
			    	clearInterval(main);
			    	var then = Date.now();
			    	monsterCought = 0;
			    	acabouTempo = 5000;
			    	break;
		    	}
	    		    
	    	default:
        		nivel = 0;
	    		window.alert("Voce capturou: " + monsterCought + " e perdeu o jogo.");
		    	reset();
		    	clearInterval(main);
		    	var then = Date.now();
		    	monsterCought = 0;
		    	acabouTempo = 5000;


		 }
	}

	if(acabouTempo >= 0){
	    	
	    	acabouTempo = acabouTempo - 1;

	    }

};


//Loop do Jogo
var main = function(){
	//Retornar número em milissegundos
	var now = Date.now();
	var delta = now - then;
	update(delta / 1000);
	render();
	then = now;
	var intervalo = setTimeout(acabou(), 10000);

};




//Inicia o Jogo
reset();
var then = Date.now();
//O método setInterval chama uma função ou avalia uma expressão em intervalos específicos (em milissegundos) 
setInterval(main, 1);