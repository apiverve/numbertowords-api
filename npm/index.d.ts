declare module '@apiverve/numbertowords' {
  export interface numbertowordsOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface numbertowordsResponse {
    status: string;
    error: string | null;
    data: NumbertoWordsData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface NumbertoWordsData {
      number:                number | null;
      words:                 null | string;
      ordinal:               null | string;
      numberOfDigitsNumeric: number | null;
      numberOfDigitsWords:   null | string;
      eachNumber:            (null | string)[];
      afterDecimal:          AfterDecimal;
      locale:                null | string;
  }
  
  interface AfterDecimal {
      number:                null | string;
      words:                 (null | string)[];
      numberOfDigitsNumeric: number | null;
      numberOfDigitsWords:   null | string;
  }

  export default class numbertowordsWrapper {
    constructor(options: numbertowordsOptions);

    execute(callback: (error: any, data: numbertowordsResponse | null) => void): Promise<numbertowordsResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: numbertowordsResponse | null) => void): Promise<numbertowordsResponse>;
    execute(query?: Record<string, any>): Promise<numbertowordsResponse>;
  }
}
