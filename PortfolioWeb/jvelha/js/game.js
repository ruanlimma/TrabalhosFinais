function mudarSimbolo(img)
{
    var simbolo =  $( "label[id='player']").text();
    if(simbolo == "X")
    {
        $( "label[id='player']").text('O');
        $(img).css("background-image","url('img/x.jpg')");

    }
    else
    {
        $( "label[id='player']").text('X');
        $(img).css("background-image","url('img/o.jpg')");
    }

}

var valida = 0;

$(document).ready(function()
{

        $( "button[name='x1']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();

            valida = valida + 1; 

            $("button[name='x1']").text(simbolo);

            var img = "button[name='x1']";

            mudarSimbolo(img);


        });


        $( "button[name='x2']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();

         

            valida = valida + 1; 


            $( "button[name='x2']").text(simbolo);

            var img = "button[name='x2']";

            mudarSimbolo(img);

        });

            $( "button[name='x3']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();

          

            valida = valida + 1; 


            $( "button[name='x3']").text(simbolo);

             var img = "button[name='x3']";

            mudarSimbolo(img);


        });

        $( "button[name='y1']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();

  

            valida = valida + 1; 


            $( "button[name='y1']").text(simbolo);

             var img = "button[name='y1']";

            mudarSimbolo(img);

        });

        $( "button[name='y2']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();

          

            valida = valida + 1; 


            $( "button[name='y2']").text(simbolo);

              var img = "button[name='y2']";

            mudarSimbolo(img);

        });

        $( "button[name='y3']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();


            valida = valida + 1; 


            $( "button[name='y3']").text(simbolo);

              var img = "button[name='y3']";

            mudarSimbolo(img);

        });

        $( "button[name='z1']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();

            vvalida = valida + 1; 


            $( "button[name='z1']").text(simbolo);

            var img = "button[name='z1']";

            mudarSimbolo(img);

        });

        $( "button[name='z2']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();

            valida = valida + 1; 


            $( "button[name='z2']").text(simbolo);

            var img = "button[name='z2']";

            mudarSimbolo(img);

        });

        $( "button[name='z3']" ).click(function()
        {
            var simbolo =  $( "label[id='player']").text();

            valida = valida + 1; 


            $( "button[name='z3']").text(simbolo);

            var img = "button[name='z3']";

            mudarSimbolo(img);

        });
});



function vereficaVencendorHorizontal()
{
    var combinacao = "";
    var simbolo = "";
    for(var i = 0 ; i < 3;i++)
    {
        if (i == 0)
        {
            simbolo =  'x';
        }
        else if (i == 1 )
        {
            simbolo = 'y';
        }
        else if (i == 2)
        {
            simbolo = 'z';
        }

        //Colunas Horizontais
        for(var j = 1 ; j <= 3 ; j++)
        {

            combinacao +=  $( "button[name='" + simbolo + j +  "']").text();

            if (combinacao == "XXX")
            {
                 alert('Ganhador X');
                 reset();
                 return;
            }
            else if(combinacao == "OOO")
            {
                alert("Ganhador O");
                reset();
                return;
            }

        }
        simbolo = "";
        combinacao = "";
    }
}

function vereficaVencendorVertical()
{
    var combinacao = "";

    //alert('vertical');
    for(var i = 1 ; i<= 3; i++)
    {
        combinacao +=  $( "button[name='x" + i +  "']").text();
        combinacao +=  $( "button[name='y" + i +  "']").text();
        combinacao +=  $( "button[name='z" + i +  "']").text();

        //alert(combinacao);

        if (combinacao == "XXX")
        {
            alert('Ganhador X');
            reset();
            return;
        }
        else if (combinacao == "OOO")
        {
            alert('Ganhador O');
            reset();
            return;
        }
        combinacao = "";

    }

}

function vereficaVencendorDiagonal()
{
    var combinacao;

    combinacao =  $( "button[name='x1']").text();
    combinacao +=  $( "button[name='y2']").text();
    combinacao +=  $( "button[name='z3']").text();


    if (combinacao == "XXX")
    {
        alert('Ganhador X');
        reset();
        return;
    }
    else if (combinacao == "OOO")
    {
        alert('Ganhador O');
        reset();
        return;
    }

    combinacao = "";

    combinacao =  $( "button[name='x3']").text();
    combinacao +=  $( "button[name='y2']").text();
    combinacao +=  $( "button[name='z1']").text();

    if (combinacao == "XXX")
    {
        alert('Ganhador X');
        reset();
        return;
    }
    else if (combinacao == "OOO")
    {
        alert('Ganhador O');
        reset();
        return;
    }

}

$(document).ready(function()
{
    $("button").click(function()
    {    
        vereficaVencendorHorizontal();

        vereficaVencendorVertical();

        vereficaVencendorDiagonal();

        if(valida > 7 )
        {
            alert("Deu velha");
            reset();
        }

    });
});


function reset()
{


    valida = 0; 

    $( "button[name='x1']").css("background-image","url('img/xo.jpg')");

    $( "button[name='x2']").css("background-image","url('img/xo.jpg')");

    $( "button[name='x3']").css("background-image","url('img/xo.jpg')");    

    $( "button[name='y1']").css("background-image","url('img/xo.jpg')");

    $( "button[name='y2']").css("background-image","url('img/xo.jpg')");
      
    $( "button[name='y3']").css("background-image","url('img/xo.jpg')");

    $( "button[name='z1']").css("background-image","url('img/xo.jpg')");

    $( "button[name='z2']").css("background-image","url('img/xo.jpg')");

    $( "button[name='z3']").css("background-image","url('img/xo.jpg')");

    $( "button[name='x1']").text("");

    $( "button[name='x2']").text("");

    $( "button[name='x3']").text("");

    $( "button[name='y1']").text("");

    $( "button[name='y2']").text("");

    $( "button[name='y3']").text("");

    $( "button[name='z1']").text("");

    $( "button[name='z2']").text("");

    $( "button[name='z3']").text("");

    var combinacao = "";
    var simbolo = "";


}
