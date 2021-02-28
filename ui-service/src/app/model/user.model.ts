export class UserModel {
  public identityNumber: string;
  public name: string;
  public surname: string;
  public phone: string;
  public city: string;
  public score: bigint;

  constructor(identityNumber: string, name: string, surname: string, phone: string, city: string, score: bigint) {
    this.identityNumber = identityNumber;
    this.name = name;
    this.surname = surname;
    this.phone = phone;
    this.city = city;
    this.score = score;
  }

}
