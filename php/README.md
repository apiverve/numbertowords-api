# Number to Words API - PHP Package

Number to Words is a number to words API that converts numeric values into written cardinal words and counts whole and fractional digits. Pass any integer or float to get the spelled-out text along with digit counts and locale information.

## Installation

Install via Composer:

```bash
composer require apiverve/numbertowords
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Numbertowords\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['number' => 975.07]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Numbertowords\Client;
use APIVerve\Numbertowords\Exceptions\APIException;
use APIVerve\Numbertowords\Exceptions\ValidationException;

try {
    $response = $client->execute(['number' => 975.07]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/numbertowords?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/numbertowords?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/numbertowords?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
