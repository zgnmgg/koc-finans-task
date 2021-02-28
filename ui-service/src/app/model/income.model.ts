export class Income {
  public code: bigint;
  public multipler: bigint;
  public description: string

  constructor(code: bigint, multipler: bigint, description: string) {
    this.code = code;
    this.multipler = multipler;
    this.description = description;
  }
}
