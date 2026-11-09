# Number to Words API - Dart/Flutter Client

Number to Words is a number to words API that converts numeric values into written cardinal words and counts whole and fractional digits. Pass any integer or float to get the spelled-out text along with digit counts and locale information.

[![pub package](https://img.shields.io/pub/v/apiverve_numbertowords.svg)](https://pub.dev/packages/apiverve_numbertowords)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Number to Words API](https://apiverve.com/marketplace/numbertowords?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_numbertowords: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_numbertowords/apiverve_numbertowords.dart';

void main() async {
  final client = NumbertowordsClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'number': 975.07
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "number": 975.07,
    "words": "nine hundred seventy-five point zero seven",
    "ordinal": "nine hundred seventy-fifth point zero seven",
    "numberOfDigits_numeric": 3,
    "numberOfDigits_words": "three",
    "eachNumber": [
      "nine",
      "seven",
      "five"
    ],
    "afterDecimal": {
      "number": "07",
      "words": [
        "zero",
        "seven"
      ],
      "numberOfDigits_numeric": 2,
      "numberOfDigits_words": "two"
    },
    "locale": "en-US"
  }
}
```

## API Reference

- **API Home:** [Number to Words API](https://apiverve.com/marketplace/numbertowords?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/numbertowords](https://docs.apiverve.com/ref/numbertowords?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
