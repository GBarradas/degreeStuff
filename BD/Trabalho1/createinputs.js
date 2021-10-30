var name='Gonçalo'
var paises=['Albânia','Alemanha','Andorra','Armênia','Áustria','Bélgica','Bielorrúsia','Bósnia e Herzegovina','Bulgária','Chipre','Croátia','Dinamarca','Eslováquia','Eslovênia','Espanha','Estônia','Filândia','França','Grécia','Hungria','Irlanda','Islândia','Itália','Letônia','Liechtenstein','Lituânia','Luxemburgo','Malta','Moldávia','Mônaco','Montenegro','Noruega','Países Baixos','Polônia','Portugal','República Checa','Macedônia do Norte','Irlanda do Norte','Inglaterra','Escócia','País de Gales','Romênia','Rússia','San Marinho','Sérvia','Suécia','Suíça','Turquia','Ucrânia','Vaticano'  ]

for(let i in paises){
    console.log("INSERT INTO gostade VALUES('"+name+"','"+paises[i]+"');")
}
