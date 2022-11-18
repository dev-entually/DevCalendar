export interface Code<T = string> {
  label: string;
  value: T;
}

export interface CheckableTagsInputProps extends InputWithOptions {}

export interface InputWithOptions<T = string> {
  options: Code<T>[];
  selected: T[];
  onChange: (selected: T[]) => void;
  resolver?: (option: Code<T>) => string | T;
}