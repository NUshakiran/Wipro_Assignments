export interface Patient {
  id?: number;
  name: string;
  email: string;
  contactNumber: string;
  age: number;
  gender: 'MALE' | 'FEMALE';
  "insuranceProvider": string,
  "insuranceNumber": string

  
}
