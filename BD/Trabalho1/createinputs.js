
var name='Carlos'
var paises=['Portugal', 'Angola','Guiné Equatorial', 'Cabo Verde', 'Guiné-Bissau', 'Moçambique' ,'Brasil', 'Macau', 'São Tomé e Príncipe', 'Timor-Leste'];

for(let i in paises){
    console.log("INSERT INTO gostade VALUES('"+name+"','"+paises[i]+"');")
}