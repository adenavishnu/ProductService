# Contributing to Products Service

Thank you for your interest in contributing to Products Service! This document provides guidelines and instructions for contributing.

## Code of Conduct

Please be respectful and constructive in all interactions. We are committed to providing a welcoming and inclusive environment for everyone.

## Getting Started

1. Fork the repository
2. Clone your fork locally
3. Set up the development environment (see [README.md](README.md))
4. Create a new branch for your feature or fix

## Development Workflow

### Branch Naming

Use descriptive branch names:
- `feature/add-product-search` - for new features
- `fix/product-validation-error` - for bug fixes
- `docs/update-api-documentation` - for documentation updates
- `refactor/product-service-cleanup` - for code refactoring

### Commit Messages

Follow conventional commit format:

```
type(scope): description

[optional body]

[optional footer]
```

Types:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

Examples:
```
feat(products): add product search endpoint
fix(validation): correct price validation logic
docs(readme): update installation instructions
```

## Code Style

### Java Guidelines

- Follow standard Java naming conventions
- Use meaningful variable and method names
- Add Javadoc for public classes and methods
- Keep methods focused and concise (ideally < 30 lines)
- Use constructor injection for dependencies

### Project Conventions

- DTOs should be in the `dtos` package
- Use interfaces for services (`IProductService`)
- Entity classes extend `BaseModel`
- Use Lombok annotations where appropriate (`@Getter`, `@Setter`)

## Testing

- Write unit tests for new functionality
- Ensure all existing tests pass before submitting
- Aim for meaningful test coverage

Run tests:
```bash
.\mvnw.cmd test
```

## Pull Request Process

1. Ensure your code follows the project's style guidelines
2. Update documentation if needed
3. Add tests for new functionality
4. Ensure all tests pass
5. Create a Pull Request with a clear description

### PR Description Template

```markdown
## Description
Brief description of the changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Testing
Describe testing done

## Checklist
- [ ] Code follows style guidelines
- [ ] Tests added/updated
- [ ] Documentation updated
- [ ] All tests pass
```

## Reporting Issues

When reporting issues, please include:
- Clear description of the problem
- Steps to reproduce
- Expected vs actual behavior
- Environment details (Java version, OS, etc.)

## Questions?

Feel free to open an issue for any questions about contributing.
