/// Response models for the Number to Words API.

/// API Response wrapper.
class NumbertowordsResponse {
  final String status;
  final dynamic error;
  final NumbertowordsData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  NumbertowordsResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory NumbertowordsResponse.fromJson(Map<String, dynamic> json) => NumbertowordsResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? NumbertowordsData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Number to Words API.

class NumbertowordsData {
  num? number;
  String? words;
  String? ordinal;
  num? numberOfDigitsNumeric;
  String? numberOfDigitsWords;
  List<String>? eachNumber;
  NumbertowordsDataAfterdecimal? afterDecimal;
  String? locale;

  NumbertowordsData({
    this.number,
    this.words,
    this.ordinal,
    this.numberOfDigitsNumeric,
    this.numberOfDigitsWords,
    this.eachNumber,
    this.afterDecimal,
    this.locale,
  });

  factory NumbertowordsData.fromJson(Map<String, dynamic> json) => NumbertowordsData(
      number: json['number'],
      words: json['words'],
      ordinal: json['ordinal'],
      numberOfDigitsNumeric: json['numberOfDigits_numeric'],
      numberOfDigitsWords: json['numberOfDigits_words'],
      eachNumber: (json['eachNumber'] as List?)?.cast<String>(),
      afterDecimal: json['afterDecimal'] != null ? NumbertowordsDataAfterdecimal.fromJson(json['afterDecimal']) : null,
      locale: json['locale'],
    );
}

class NumbertowordsDataAfterdecimal {
  String? number;
  List<String>? words;
  num? numberOfDigitsNumeric;
  String? numberOfDigitsWords;

  NumbertowordsDataAfterdecimal({
    this.number,
    this.words,
    this.numberOfDigitsNumeric,
    this.numberOfDigitsWords,
  });

  factory NumbertowordsDataAfterdecimal.fromJson(Map<String, dynamic> json) => NumbertowordsDataAfterdecimal(
      number: json['number'],
      words: (json['words'] as List?)?.cast<String>(),
      numberOfDigitsNumeric: json['numberOfDigits_numeric'],
      numberOfDigitsWords: json['numberOfDigits_words'],
    );
}

class NumbertowordsRequest {
  double number;

  NumbertowordsRequest({
    required this.number,
  });

  Map<String, dynamic> toJson() => {
      'number': number,
    };
}
