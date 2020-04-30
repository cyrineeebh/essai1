import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ClientComponent } from './components/client/client.component';
import { DetailsComponent } from './components/details/details.component';
import { InstructionComponent } from './components/instruction/instruction.component';
import { TransactionComponent } from './components/transaction/transaction.component';
import { ContactComponent } from './components/contact/contact.component';
import { FooterComponent } from './components/footer/footer.component';
 
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ClientComponent,
    DetailsComponent,
    InstructionComponent,
    TransactionComponent,
    ContactComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule ,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
