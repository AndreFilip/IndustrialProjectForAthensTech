import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-instructors',
  templateUrl: './instructors.component.html',
  styleUrls: ['./instructors.component.css']
})
export class InstructorsComponent implements OnInit {
  nikolako2: string;
  giannacoulis: string;
  katsaris: string;
  prodromou: string;
  kalipetis: string;
  peristeris: string;
  argyroiliopoulos: string;
  matthaios: string;
  oikonomopoulos: string;
  kakavoulis: string;
  chatzigeorgiou: string;
  kotsidimos: string;
  tsakalis: string;
  vidros: string;
  zyka: string;
  koutsoulelos: string;
  tagaris: string;
  konstantinidis: string;



  constructor() {
    this.nikolako2 = '/assets/images/nikolako.png';
    this.giannacoulis = '/assets/images/giannacoulis.jpg';
    this.katsaris = '/assets/images/katsaris.jpg';
    this.prodromou = '/assets/images/prodromou.png';
    this.kalipetis = '/assets/images/kalipetis.jpg';
    this.peristeris = '/assets/images/peristeris.jpg';
    this.argyroiliopoulos = '/assets/images/argyroiliopoulos.jpg';
    this.matthaios = '/assets/images/matthaios.png';
    this.oikonomopoulos = '/assets/images/oikonomopoulos.jpg';
    this.kakavoulis = '/assets/images/kakavoulis.jpg';
    this.chatzigeorgiou = '/assets/images/chatzigeorgiou.jpg';
    this.kotsidimos = '/assets/images/kotsidimos.jpg';
    this.tsakalis = '/assets/images/tsakalis.jpg';
    this.vidros = '/assets/images/vidros.jpg';
    this.zyka = '/assets/images/zyka.jpg';
    this.koutsoulelos = '/assets/images/koutsoulelos.png';
    this.tagaris = '/assets/images/tagaris.png';
    this.konstantinidis = '/assets/images/konstantinidis.png';

   }





  ngOnInit() {
  }

}
